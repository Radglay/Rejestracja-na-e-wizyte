package projekt.ewizyta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Setter
@Getter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String pesel;

    private String telephone;


    @OneToMany(mappedBy="user_data", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<eSkierowanie> skierowania;

    @OneToMany(mappedBy="user_data", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<eRecepta> recepty;

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

    public User(String email, String password, String name, String surname,String telephone, String pesel, Collection<Role> roles) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.pesel = pesel;
        this.telephone = telephone;
        this.roles = roles;
    }

}

