package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * Role Object for Database
 *
 * @author <a href="mailto:amgrill@gmail.com">Xavier Rodríguez</a>
 *
 */

@Entity
@Table (name = "ROLES")
@Getter @Setter
public class Roles {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id;

    private String code;

    private String description;
}
