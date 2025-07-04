package zairastra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Users")
public class User {

    //ATTRIBUTI
    @Id
    @Column(name = "cardCode_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cardCode;

    private String name;
    private String surname;
    private LocalDate birthDate;


    //COSTRUTTORI
    public User() {
    }

    ;

    public User(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    //METODI


    public String getCardCode() {
        return cardCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "cardCode='" + cardCode + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
        
    }
}
