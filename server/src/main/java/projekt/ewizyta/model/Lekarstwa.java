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
public class Lekarstwa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int eRecepta_id;

    private int lek_id;
}
