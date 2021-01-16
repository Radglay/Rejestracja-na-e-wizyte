package projekt.ewizyta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class eRecepta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference(value="user-recepta")
    private User user_data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference//(value="doctor-recepta")
    private Doctor doctor_data;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kod; //dostepu

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lekarstwa",
            joinColumns = @JoinColumn(
                    name = "eRecepta_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "lek_id", referencedColumnName = "id")
    )
    private Collection<Lek> lekarstwa;

    //private LocalDate czas = LocalDate.now();
    private LocalDate czas;

    public eRecepta() {}

    public eRecepta(User user_data, Doctor doctor_data, Long kod, Collection<Lek> lekarstwa) {
        super();
        this.user_data = user_data;
        this.doctor_data = doctor_data;
        this.kod = kod;
        this.lekarstwa = lekarstwa;
        this.czas = LocalDate.now();
    }

}
