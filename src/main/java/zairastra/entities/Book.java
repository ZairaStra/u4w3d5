package zairastra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Book extends CatalogueElement {

    //ATTRIBUTI
    @Column(name = "Author")
    private String author;
    @Column(name = "Genre")
    private String genre;

    //COSTRUTTORI
    public Book() {
    }

    public Book(String isbn, String title, int pubYear, int pageNumb, String author, String genre) {
        super(isbn, title, pubYear, pageNumb);
        this.author = author;
        this.genre = genre;
    }

    //METODI

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
