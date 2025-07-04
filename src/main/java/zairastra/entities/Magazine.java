package zairastra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import zairastra.entities.enums.Periodicity;

@Entity
public class Magazine extends CatalogueElement {

    //ATTRIBUTI
    @Column(name = "Periodicity")
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    //COSTRUTTORI
    public Magazine() {
    }

    public Magazine(String title, int pubYear, int pageNumb, Periodicity periodicity) {
        super(title, pubYear, pageNumb);
        this.periodicity = periodicity;
    }

    //METODI


    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return super.toString() + "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}
