package iogrupa5.ewizyta.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "email")
    private String email;

    @Column(name="haslo")
    private String haslo;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "typ")
    @Builder.Default
    private Grupa typ = Grupa.USER;

    public User(){

    }

    public User(String imie, String nazwisko, String email, String haslo, String pesel, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.pesel = pesel;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Grupa getTyp() {
        return typ;
    }

    public void setTyp(Grupa typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "User{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", pesel='" + pesel + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
