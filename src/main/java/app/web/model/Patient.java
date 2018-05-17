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
 * Domain object Patient.
 * 
 * @since 2018.05.15
 * @author annik
 */
@Entity
@Table( name = "patient" )
public class Patient implements Serializable {

    @Id
    @Column( nullable = false, unique = true )
    @GeneratedValue
    private Integer gid;

    @Column( length = 128, nullable = false )
    private String name;

    @Column( length = 1, nullable = true )
    private String gender;

    @Column( nullable = true )
    @DateTimeFormat( pattern = "MM/dd/YYYY" )
    private LocalDate birthday;

    /**
     * Default Contructor.
     *
     */
    public Patient() {

    }

    /**
     * Contructor.
     * 
     * @param name
     *            of the Patient. Mandatory value.
     */
    public Patient( String name ) {

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

    public String getGender() {

        return gender;
    }

    public void setGender( String gender ) {

        this.gender = gender;
    }

    public LocalDate getBirthday() {

        return birthday;
    }

    public void setBirthday( LocalDate birthday ) {

        this.birthday = birthday;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "Patient [gid=" );
        builder.append( gid );
        builder.append( ", name=" );
        builder.append( name );
        builder.append( ", sex=" );
        builder.append( gender );
        builder.append( ", birthday=" );
        builder.append( birthday );
        builder.append( "]" );
        return builder.toString();
    }

}
