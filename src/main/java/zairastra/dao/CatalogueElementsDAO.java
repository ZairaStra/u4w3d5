package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import zairastra.entities.Book;
import zairastra.entities.CatalogueElement;
import zairastra.exceptions.NotFoundException;

import java.util.List;

public class CatalogueElementsDAO {
    private EntityManager entityManager;

    public CatalogueElementsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //METODI PER SALVARE, CERCARE (ED ELIMINARE?) GLI ELEMENTI DEL CATALOGO
    //ESSENDO CatalogueElement UNA SUPERCLASSE, SFRUTTANDO IL POLIMORFISMO DEFINISCO I METODI PER LA SUPERCLASSE
    //CHE PERò FUNZIONERANNO PERFETTAMENTE ANCHE PER Book E Magazine

    //save
    public void saveCatalogueElement(CatalogueElement newCatalogueElement) {

        EntityTransaction transaction = entityManager.getTransaction();
        //apro transazione
        transaction.begin();
        //"prendo in carico" il nuovo elemento
        entityManager.persist(newCatalogueElement);
        //lo aggiungo al db
        transaction.commit();

        System.out.println(newCatalogueElement.getTitle() + " è stato aggiunto al catalogo");
    }

    //findBy
    public CatalogueElement findById(String isbn) {
        CatalogueElement found = entityManager.find(CatalogueElement.class, isbn);
        if (found == null) throw new NotFoundException(isbn);
        return found;
    }

    //delete?
    public void deleteCatalogueElement(CatalogueElement newCatalogueElement) {

        CatalogueElement found = this.findById(newCatalogueElement.getIsbn());

        EntityTransaction transaction = entityManager.getTransaction();
        //apro transazione
        transaction.begin();
        //"prendo in carico" il nuovo elemento
        entityManager.remove(found);
        //lo aggiungo al db
        transaction.commit();

        System.out.println(newCatalogueElement.getTitle() + " è stato rimosso dal catalogo");
    }

    //ricerca per nome autore
    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.author=:author", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    //ricerca per anno pubblicazione
    public List<CatalogueElement> findByPubYear(int pubYear) {
        TypedQuery<CatalogueElement> query = entityManager.createQuery("SELECT c FROM CatalogueElement c WHERE c.pubYear= :year", CatalogueElement.class);
        query.setParameter("year", pubYear);
        return query.getResultList();
    }
}
