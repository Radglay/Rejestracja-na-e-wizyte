package projekt.ewizyta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Wizyta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference(value="user-wizyta")
    private User user_data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference
    private Doctor doctor_data;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public Wizyta() {}

    public Wizyta(User user_data, Doctor doctor_data, int year, int month, int day, int hour, int minute) {
        super();
        this.user_data = user_data;
        this.doctor_data = doctor_data;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
}
