package projekt.ewizyta.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Setter
@Getter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;

    private String nazwisko;

    private String email;

    private String password;

    private String pesel;

    private String telefon;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User(){

    }

    public User(String imie, String nazwisko, String email, String password, String pesel, String telefon, Collection<Role> roles) {
        super();
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.password = password;
        this.pesel = pesel;
        this.telefon = telefon;
        this.roles = roles;
    }

}

