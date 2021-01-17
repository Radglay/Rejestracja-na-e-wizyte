package projekt.ewizyta.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    //rozszerza user'a

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;


    @OneToMany(mappedBy="doctor_data", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference//(value="doctor-skierowanie")
    private Set<eSkierowanie> skierowania;

    @OneToMany(mappedBy="doctor_data", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference//(value="doctor-recepta")
    private Set<eSkierowanie> recepty;

    @OneToMany(mappedBy="doctor_data", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value="doctor-wizyta")
    private Set<Wizyta> wizyty;

    public Doctor() {}

    public Doctor(String type) {
        super();
        this.type = type;
    }
}
