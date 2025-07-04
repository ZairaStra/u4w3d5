package zairastra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import zairastra.dao.CatalogueElementsDAO;
import zairastra.entities.Book;
import zairastra.entities.CatalogueElement;
import zairastra.entities.Magazine;
import zairastra.entities.enums.Periodicity;

public class Application {
    //FAI ATTENZIONE: DEVE CHIAMARSI ESATTAMENTE COME è SCRITTO NEL PERSISTENCE.XML
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {
        //CREO EM E DAO
        EntityManager em = emf.createEntityManager();
        CatalogueElementsDAO cd = new CatalogueElementsDAO(em);

        //CREO UNA SERIE DI LIBRI E UNA DI RIVISTE
        Book firstBook = new Book("Il Signore degli Anelli - La Compagnia dell'Anello", 2019, 704, "J.R.R. Tolkien", "fantasy");
        Book secondBook = new Book("Il Signore degli Anelli - Le due Torri", 2020, 592, "J.R.R. Tolkien", "fantasy");
        Book thirdBook = new Book("Il Signore degli Anelli - La Compagnia dell'Anello", 2020, 624, "J.R.R. Tolkien", "fantasy");
        Book fourthBook = new Book("Il Signore degli Anelli - Edizione illustrata da ALan Lee", 2017, 1255, "J.R.R. Tolkien", "fantasy");
        Book fifthBook = new Book("Il Nome della Rosa", 1987, 534, "Umberto Eco", "storico");
        Book sixthBook = new Book("La Versione di Barney", 2000, 490, "Mordecai Richler", "narrativa");
        Book seventhBook = new Book("Le sette morti di Evelyn Hardcastle", 2019, 448, "Stuart Turton", "thriller");


        Magazine firstMagazine = new Magazine("Science", 2025, 88, Periodicity.WEEKLY);
        Magazine secondMagazine = new Magazine("The AMerican Journal of Medicine", 2023, 79, Periodicity.MONTHLY);
        Magazine thirdMagazine = new Magazine("Domus", 2019, 59, Periodicity.MONTHLY);
        Magazine fourthMagazine = new Magazine("ArtApp", 2009, 68, Periodicity.SEMI_ANNUAL);
        Magazine fifthMagazine = new Magazine("Il Minotauro", 1983, 38, Periodicity.SEMI_ANNUAL);


//        cd.saveCatalogueElement(firstBook);
//        cd.saveCatalogueElement(secondBook);
//        cd.saveCatalogueElement(thirdBook);
//        cd.saveCatalogueElement(fourthBook);
//        cd.saveCatalogueElement(fifthBook);
//        cd.saveCatalogueElement(sixthBook);
//        cd.saveCatalogueElement(seventhBook);

//        cd.saveCatalogueElement(fifthMagazine);
//        cd.saveCatalogueElement(secondMagazine);
//        cd.saveCatalogueElement(thirdMagazine);
//        cd.saveCatalogueElement(fourthMagazine);
//        cd.saveCatalogueElement(fifthMagazine);

        //PROBLEMA: SALVA CORRETTAMENTE UNA VOLTA SOLA PER SAVE ANCHE SE TENTO DI SALVARE DUE VOLTE, PERò IN CONSOLE MI DA COMUNQUE MESSAGGIO DI AVVENUTO SALVATAGGIO
        //DOVREI FARE UN IF?

        //find
        CatalogueElement e1FromDb = cd.findById("0f5c2158-90be-44d1-a78d-0a09072f77ed");
        System.out.println("L'elemento corrispondente al codice ISBN inserito è: " + e1FromDb.getTitle());

        //delete
        //cd.deleteCatalogueElement(e1FromDb);

        //finByAUthor
        cd.findByAuthor("Tolkien").forEach(System.out::println);
        cd.findByAuthor("Turton").forEach(System.out::println);

        //findByPubYear
        cd.findByPubYear(2019).forEach(System.out::println);
        cd.findByPubYear(2025).forEach(System.out::println);
        cd.findByPubYear(1987).forEach(System.out::println);

        em.close();
        emf.close();
    }
}
