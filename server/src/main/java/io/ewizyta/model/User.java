package io.ewizyta.model;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="USERS")
@ToString
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

    @Column(name="password")
    private String password;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "telefon")
    private String telefon;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;;

    public User(){

    }

    public User(String imie, String nazwisko, String email, String password, String pesel, String telefon, Collection<Role> roles) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.password = password;
        this.pesel = pesel;
        this.telefon = telefon;
        this.roles = roles;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPesel() {
        return pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
}
