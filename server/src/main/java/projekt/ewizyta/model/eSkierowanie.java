package projekt.ewizyta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class eSkierowanie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference(value="user-skierowanie")
    private User user_data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference//(value="doctor-skierowanie")
    private Doctor doctor_data;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kod; //dostepu

    private LocalDate czas;

    public eSkierowanie() {}

    public eSkierowanie(User user_data, Doctor doctor_data) {
        super();
        this.user_data = user_data;
        this.doctor_data = doctor_data;
        this.czas = LocalDate.now();
    }
}
