package zairastra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import zairastra.dao.CatalogueElementsDAO;
import zairastra.dao.LoansDAO;
import zairastra.dao.UsersDAO;
import zairastra.entities.Book;
import zairastra.entities.Loan;
import zairastra.entities.Magazine;
import zairastra.entities.User;
import zairastra.entities.enums.Periodicity;

import java.time.LocalDate;

public class Application {
    //FAI ATTENZIONE: DEVE CHIAMARSI ESATTAMENTE COME è SCRITTO NEL PERSISTENCE.XML
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {
        //CREO EM E DAO
        EntityManager em = emf.createEntityManager();
        CatalogueElementsDAO cd = new CatalogueElementsDAO(em);
        LoansDAO ld = new LoansDAO(em);
        UsersDAO ud = new UsersDAO(em);

        //CREO UNA SERIE DI LIBRI E UNA DI RIVISTE
        Book firstBook = new Book("Il Signore degli Anelli - La Compagnia dell'Anello", 2019, 704, "J.R.R. Tolkien", "fantasy");
        Book secondBook = new Book("Il Signore degli Anelli - Le due Torri", 2020, 592, "J.R.R. Tolkien", "fantasy");
        Book thirdBook = new Book("Il Signore degli Anelli - La Compagnia dell'Anello", 2020, 624, "J.R.R. Tolkien", "fantasy");
        Book fourthBook = new Book("Il Signore degli Anelli - Edizione illustrata da ALan Lee", 2017, 1255, "J.R.R. Tolkien", "fantasy");
        Book fifthBook = new Book("Il Nome della Rosa", 1987, 534, "Umberto Eco", "storico");
        Book sixthBook = new Book("La Versione di Barney", 2000, 490, "Mordecai Richler", "narrativa");
        Book seventhBook = new Book("Le sette morti di Evelyn Hardcastle", 2019, 448, "Stuart Turton", "thriller");


        Magazine firstMagazine = new Magazine("Science", 2023, 88, Periodicity.WEEKLY);
        Magazine secondMagazine = new Magazine("The AMerican Journal of Medicine", 2018, 79, Periodicity.MONTHLY);
        Magazine thirdMagazine = new Magazine("Domus", 2007, 59, Periodicity.MONTHLY);
        Magazine fourthMagazine = new Magazine("ArtApp", 2009, 68, Periodicity.SEMI_ANNUAL);
        Magazine fifthMagazine = new Magazine("Il Minotauro", 1983, 38, Periodicity.SEMI_ANNUAL);


        cd.saveCatalogueElement(firstBook);
        cd.saveCatalogueElement(secondBook);
        cd.saveCatalogueElement(thirdBook);
        cd.saveCatalogueElement(fourthBook);
        cd.saveCatalogueElement(fifthBook);
        cd.saveCatalogueElement(sixthBook);
        cd.saveCatalogueElement(seventhBook);

        cd.saveCatalogueElement(fifthMagazine);
        cd.saveCatalogueElement(firstMagazine);
        cd.saveCatalogueElement(secondMagazine);
        cd.saveCatalogueElement(thirdMagazine);
        cd.saveCatalogueElement(fourthMagazine);
        cd.saveCatalogueElement(fifthMagazine);

        //PROBLEMA: SALVA CORRETTAMENTE UNA VOLTA SOLA PER SAVE ANCHE SE TENTO DI SALVARE DUE VOLTE, PERò IN CONSOLE MI DA COMUNQUE MESSAGGIO DI AVVENUTO SALVATAGGIO
        //DOVREI FARE UN IF?
        //SCHERZAVO SONO DUPLICATI PURE I SALVATAGGI

//        //find
//        CatalogueElement e1FromDb = cd.findById("0f5c2158-90be-44d1-a78d-0a09072f77ed");
//        System.out.println("L'elemento corrispondente al codice ISBN inserito è: " + e1FromDb.getTitle());

        //delete
        //cd.deleteCatalogueElement(e1FromDb);

        //finByAUthor
        cd.findByAuthor("Tolkien").forEach(System.out::println);
        cd.findByAuthor("Turton").forEach(System.out::println);

        //findByPubYear
        cd.findByPubYear(2019).forEach(System.out::println);
        cd.findByPubYear(2025).forEach(System.out::println);
        cd.findByPubYear(1987).forEach(System.out::println);

        //findByTitle
        cd.findByTitle("signore").forEach(System.out::println);
        cd.findByTitle("am").forEach(System.out::println);
        cd.findByTitle("Evelyn").forEach(System.out::println);

        
        //creo una serie di utenti
        User firstUser = new User("Zaira", "Straticò", LocalDate.of(1993, 1, 28));
        User secondUser = new User("Matteo", "Alfano", LocalDate.of(1993, 11, 8));
        User thirdUser = new User("Lady", "Rose", LocalDate.of(1987, 6, 4));
        User fourthUser = new User("Gloria", "Pantalla", LocalDate.of(1978, 3, 15));
        User fifthUser = new User("Paolo", "Mariucci", LocalDate.of(1957, 7, 19));
        User sixthUser = new User("Oscar", "Scalfaro", LocalDate.of(1942, 9, 12));

        ud.saveUser(firstUser);
        ud.saveUser(secondUser);
        ud.saveUser(thirdUser);
        ud.saveUser(fourthUser);
        ud.saveUser(fifthUser);
        ud.saveUser(sixthUser);

//        //find
//        User u1FromDb = ud.findById("");
//        System.out.println("L'utente corrispondente al codice di tessera inserito è: " + u1FromDb.getName() +" "+u1FromDb.getSurname);

        //delete
        //ud.deleteCatalogueElement(d1FromDb);

        //creo una serie di prestiti
        Loan firstLoan = new Loan(thirdBook, fifthUser, LocalDate.of(2025, 4, 12), LocalDate.of(2025, 4, 12).plusDays(30), LocalDate.of(2025, 5, 3));
        Loan secondLoan = new Loan(firstBook, firstUser, LocalDate.now(), LocalDate.now().plusDays(30), null);
        Loan thirdLoan = new Loan(firstMagazine, thirdUser, LocalDate.of(2025, 2, 2), LocalDate.of(2025, 2, 2).plusDays(30), LocalDate.of(2025, 5, 15));
        Loan fourthLoan = new Loan(seventhBook, firstUser, LocalDate.of(2024, 10, 18), LocalDate.of(2024, 10, 18).plusDays(30), LocalDate.of(2025, 1, 28));
        Loan fifthLoan = new Loan(fourthMagazine, secondUser, LocalDate.of(2019, 5, 12), LocalDate.of(2025, 4, 12).plusDays(30), LocalDate.of(2025, 5, 3));
        Loan sixthLoan = new Loan(secondMagazine, sixthUser, LocalDate.of(2019, 7, 6), LocalDate.of(2019, 7, 6).plusDays(30), null);

        ld.saveLoan(firstLoan);
        ld.saveLoan(secondLoan);
        ld.saveLoan(thirdLoan);
        ld.saveLoan(fourthLoan);
        ld.saveLoan(fifthLoan);
        ld.saveLoan(sixthLoan);

        //        //find
//        Loan l1FromDb = ld.findById("");
//        System.out.println("Il prestito con numero seriale corrispondente all'inserito è: " +l1FromDb);

        //delete
        //ud.deleteCatalogueElement(d1FromDb);


        em.close();
        emf.close();
    }
}
