package zairastra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Loans")
public class Loan {

    //ATTRIBUTI

    @Id
    @Column(name = "loan_code", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //collego Loan a CatalogueElement
    @ManyToOne
    @JoinColumn(name = "catalogueElement_id", referencedColumnName = "isbn", nullable = false)
    private CatalogueElement catalogueElement;

    //collego Loan a User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "cardCode_id", nullable = false)
    private User user;

    @Column(name = "loan start date")
    private LocalDate startLoanDate;

    @Column(name = "loan expiration date")
    private LocalDate expirationLoanDate;

    @Column(name = "return date")
    private LocalDate returnDate;


    //COSTRUTTORI

    public Loan() {
    }

    ;

    public Loan(CatalogueElement catalogueElement, User user, LocalDate startLoanDate, LocalDate expirationLoanDate, LocalDate returnDate) {
        this.catalogueElement = catalogueElement;
        this.user = user;
        this.startLoanDate = startLoanDate;
        this.expirationLoanDate = expirationLoanDate;
        this.returnDate = returnDate;
    }

    //METODI


    public String getId() {
        return id;
    }

    public CatalogueElement getCatalogueElement() {
        return catalogueElement;
    }

    public void setCatalogueElement(CatalogueElement catalogueElement) {
        this.catalogueElement = catalogueElement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartLoanDate() {
        return startLoanDate;
    }

    public void setStartLoanDate(LocalDate startLoanDate) {
        this.startLoanDate = startLoanDate;
    }

    public LocalDate getExpirationLoanDate() {
        return expirationLoanDate;
    }

    public void setExpirationLoanDate(LocalDate expirationLoanDate) {
        this.expirationLoanDate = expirationLoanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", catalogueElement=" + catalogueElement +
                ", user=" + user +
                ", startLoanDate=" + startLoanDate +
                ", expirationLoanDate=" + expirationLoanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
