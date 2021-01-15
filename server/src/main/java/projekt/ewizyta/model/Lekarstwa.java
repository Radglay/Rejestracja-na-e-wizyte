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
    private long id;

    private long eRecepta_id;

    private long lek_id;

    public Lekarstwa(long eRecepta_id, long lek_id) {
        super();
        this.eRecepta_id = eRecepta_id;
        this.lek_id = lek_id;
    }

    public Lekarstwa() {}
}
