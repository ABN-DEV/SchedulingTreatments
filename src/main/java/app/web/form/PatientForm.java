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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import app.web.model.Patient;

/**
 * Web form data for {@link Patient}.
 * 
 * @since 2018.05.15
 * @author annik
 */
public class PatientForm {

    private Integer gid;

    private String name;

    private String sex;

    private LocalDate birthday;

    /**
     * Default Contructor.
     *
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

    public String getSex() {

        return sex;
    }

    public void setSex( String sex ) {

        this.sex = sex;
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
        builder.append( name );
        builder.append( ", sex=" );
        builder.append( sex );
        builder.append( ", birthday=" );
        builder.append( birthday );
        builder.append( "]" );
        return builder.toString();
    }

}
