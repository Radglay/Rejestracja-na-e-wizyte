package projekt.ewizyta.model;

import lombok.Getter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class User_roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int user_id;

    private int role_id;


    public User_roles() {}

    public User_roles(int user_id, int role_id) {
        super();
        this.user_id = user_id;
        this.role_id = role_id;
    }
}