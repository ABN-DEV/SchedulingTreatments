/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import app.web.model.Patient;

/**
 * Web form data for {@link Patient}.
 * 
 * @since 2018.05.15
 * @author annik
 */
public class PatientForm {

    private Integer gid;

    @NotNull
    @Size( min = 2, max = 128 )
    private String fullName;

    // optional
    private String gender;

    // optional
    @DateTimeFormat( pattern = "MM/dd/yyyy" )
    @Past
    private LocalDate birthday;

    /**
     * Default Contructor.
     */
    public PatientForm() {

    }

    /**
     * Contructor.
     * 
     * @param name
     *            of the Patient. Mandatory value.
     */
    public PatientForm( String name ) {

        this.fullName = name;
    }

    public Integer getGid() {

        return gid;
    }

    public void setGid( Integer gid ) {

        this.gid = gid;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName( String name ) {

        this.fullName = name;
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
        builder.append( "PatientForm [gid=" );
        builder.append( gid );
        builder.append( ", name=" );
        builder.append( fullName );
        builder.append( ", sex=" );
        builder.append( gender );
        builder.append( ", birthday=" );
        builder.append( birthday );
        builder.append( "]" );
        return builder.toString();
    }

}
