package zairastra.entities;

import jakarta.persistence.*;

//lego al db
@Entity
@Table(name = "elements")

//definisco il modello relazionale
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class CatalogueElement {
    //ATTRIBUTI
    @Id //PK
    @Column(name = "isbn", nullable = false) //cambio il nome della colonna
    @GeneratedValue(strategy = GenerationType.UUID)
    //ho deciso di usare isbn fittizi rendendoil id uuid, così uso uuid in tutta l'applicazione(anche per il numero di tessera dello user)
    private String isbn;
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "Publications Year", nullable = false)
    private int pubYear;
    @Column(name = "Pages' number", nullable = false)
    private int pageNumb;

    //COSTRUTTORI
    public CatalogueElement() {
    }

    public CatalogueElement(String title, int pubYear, int pageNumb) {
        this.title = title;
        this.pubYear = pubYear;
        this.pageNumb = pageNumb;
    }

    //METODI

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }

    @Override
    public String toString() {
        return "CatalogueElement{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", pubYear=" + pubYear +
                ", pageNumb=" + pageNumb +
                '}';
    }
}
