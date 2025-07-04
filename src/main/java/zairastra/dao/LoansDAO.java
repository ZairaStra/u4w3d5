package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import zairastra.entities.Loan;
import zairastra.exceptions.NotFoundException;

import java.util.List;

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

    //prestiti in corso per utente=> null
    public List<Loan> findsByUser(String cardCode) {
        //TI DEVI RICORDARE CHE l VA MESSA ANCHE DOPO LOAN PERCHè èSE NO LUI NON SA COSA SIA
        TypedQuery<Loan> query = entityManager.createQuery("SELECT l FROM Loan l WHERE l.user.cardCode=:cardCode AND l.returnDate IS NULL", Loan.class);
        query.setParameter("cardCode", cardCode);
        return query.getResultList();
    }

    //prestiti scaduti non restituiti =>+30giorni


}
