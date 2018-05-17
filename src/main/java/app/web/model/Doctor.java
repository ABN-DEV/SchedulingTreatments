/**
 * Project ..... ProcedureScheduling<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Domain object a Doctor.
 * 
 * @since 2018.05.17
 * @author annik
 */
@Entity
@Table( name = "doctor" )
public class Doctor implements Serializable {

    @Id
    @Column( nullable = false, unique = true )
    private Integer gid;

    @Column( length = 128, nullable = false )
    private String name;

    /**
     * Default Contructor.
     *
     */
    public Doctor() {

    }

    /**
     * Contructor.
     * 
     * @param gid
     *            of the Doctor.
     * 
     * @param name
     *            of the Patient. Mandatory value.
     */
    public Doctor( Integer gid, String name ) {

        this.gid = gid;
        this.name = name;
    }

    public Integer getGid() {

        return gid;
    }

    public void setGid( Integer gid ) {

        this.gid = gid;
    }

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "Doctor [gid=" );
        builder.append( gid );
        builder.append( ", name=" );
        builder.append( name );
        builder.append( "]" );
        return builder.toString();
    }

}
