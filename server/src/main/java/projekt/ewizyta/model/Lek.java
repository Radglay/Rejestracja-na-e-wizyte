package projekt.ewizyta.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Lek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;
    private String dawkowanie;


    public Lek() {}

    public Lek(String nazwa, String dawkowanie) {
        super();
        this.nazwa = nazwa;
        this.dawkowanie = dawkowanie;
    }
}
