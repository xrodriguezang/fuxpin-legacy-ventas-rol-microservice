package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * User Object for Database
 *
 * @author Xavier Rodríguez
 *
 */

@Entity
@Table (name = "REGISTERED_USER")
@Getter @Setter
public class RegisteredUser {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id;

    private String userName;

    private String name;

    private String surname1;

    private String surname2;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    private List<LegacyRole> roles = new ArrayList<>();

    /**
     * It's override to print all data from user
     *
     * @return
     */
    @Override
    public String toString() {
        return "RegisteredUser: {" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", roles=" + roles +
                '}';
    }

}
