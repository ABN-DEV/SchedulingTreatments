/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-20<br>
 * <br>
 */
package app.web.form;

/**
 * MVC Web Form for changing Status an Appointment. It receives and stores web form data.
 * 
 * @since 2018.05.20
 * @author annik
 */
public class StatusForm {

    private String status;

    private Integer studyId;

    public String getStatus() {

        return status;
    }

    public void setStatus( String status ) {

        this.status = status;
    }

    public Integer getStudyId() {

        return studyId;
    }

    public void setStudyId( Integer studyId ) {

        this.studyId = studyId;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "StatusForm [status=" );
        builder.append( status );
        builder.append( ", studyId=" );
        builder.append( studyId );
        builder.append( "]" );
        return builder.toString();
    }

}
