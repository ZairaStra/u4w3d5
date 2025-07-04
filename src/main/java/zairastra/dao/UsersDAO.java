package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import zairastra.entities.User;
import zairastra.exceptions.NotFoundException;

public class UsersDAO {
    private EntityManager entityManager;

    public UsersDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //METODI PER SALVARE, CERCARE (ED ELIMINARE?) GLI UTENTI

    //save
    public void saveUser(User newUser) {

        EntityTransaction transaction = entityManager.getTransaction();
        //apro transazione
        transaction.begin();
        //"prendo in carico" il nuovo utente
        entityManager.persist(newUser);
        //lo aggiungo al db
        transaction.commit();

        System.out.println("L'utente " + newUser.getName() + " " + newUser.getSurname() + " è stato aggiunto allo schedario");
    }

    //findBy
    public User findById(String cardCode) {
        User found = entityManager.find(User.class, cardCode);
        if (found == null) throw new NotFoundException(cardCode);
        return found;
    }

    //delete
    public void deleteUser(User newUser) {

        User found = this.findById(newUser.getCardCode());

        EntityTransaction transaction = entityManager.getTransaction();
        //apro transazione
        transaction.begin();
        //"prendo in carico" l'utente
        entityManager.remove(found);
        //lo rimuovo dal db
        transaction.commit();

        System.out.println("L'utente " + newUser.getName() + " " + newUser.getSurname() + " è stato rimosso dal database");
    }
}
