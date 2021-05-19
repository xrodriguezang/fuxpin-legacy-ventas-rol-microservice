package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * Legacy Role Object for Database
 *
 * @author Xavier Rodríguez
 *
 */

@Entity
@Table (name = "ROLES")
@Getter @Setter
public class LegacyRole {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id;

    private String code;

    private String description;
}
