/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.form;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import app.web.model.Patient;

/**
 * Spring MVC Web form data for Scheduling procedures. <BR />
 * At Step1 of Scheduling we choose a {@link Patient} and planed date for treatment.
 * 
 * @since 2018.05.17
 * @author annik
 */
public class ScheduleStep1Form implements Serializable {

    @NotNull
    private Integer patientGid;

    /* Planed Date */
    @NotNull
    @DateTimeFormat( pattern = "MM/dd/yyyy" )
    @Future
    private LocalDate planedDate;

    public Integer getPatientGid() {

        return patientGid;
    }

    public void setPatientGid( Integer patientGid ) {

        this.patientGid = patientGid;
    }

    public LocalDate getPlanedDate() {

        return planedDate;
    }

    public void setPlanedDate( LocalDate plannedDate ) {

        this.planedDate = plannedDate;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "ScheduleStep1Form [" );
        builder.append( " patientGid=" );
        builder.append( patientGid );
        builder.append( ", plannedDate=" );
        builder.append( planedDate );
        builder.append( "]" );
        return builder.toString();
    }

}
