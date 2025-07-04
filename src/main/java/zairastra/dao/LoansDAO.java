package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import zairastra.entities.Loan;
import zairastra.exceptions.NotFoundException;

public class LoansDAO {
    private EntityManager entityManager;

    public LoansDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //metodi generici di salvataggio, ricerca per id e cancellazione dei prestiti

    //save
    public void saveLoan(Loan newLoan) {

        EntityTransaction transaction = entityManager.getTransaction();
        //apro transazione
        transaction.begin();
        //"prendo in carico" il nuovo elemento
        entityManager.persist(newLoan);
        //lo aggiungo al db
        transaction.commit();

        System.out.println("La pratica di prestito con codice " + newLoan.getId() + " è stato aggiunto allo schedario");
    }

    //findBy
    public Loan findById(String id) {
        Loan found = entityManager.find(Loan.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    //delete
    public void deleteLoan(Loan newLoan) {

        Loan found = this.findById(newLoan.getId());

        EntityTransaction transaction = entityManager.getTransaction();
        //apro transazione
        transaction.begin();
        //"prendo in carico" il nuovo elemento
        entityManager.remove(found);
        //lo rimuovo dal db
        transaction.commit();

        System.out.println("La pratica di prestito con codice " + newLoan.getId() + " è stata rimossa dallo schedario");


    }


}
