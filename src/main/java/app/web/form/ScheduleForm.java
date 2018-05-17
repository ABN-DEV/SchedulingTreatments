/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Spring MVC Web form data for Scheduling procedures.
 * 
 * @since 2018.05.17
 * @author annik
 */
public class ScheduleForm {

    private Integer gid;

    private Integer patientGid;

    private Integer doctorGid;

    private Integer roomGid;

    private String description;

    private Status status;

    @DateTimeFormat( pattern = "MM/dd/yyyy HH:mm" )
    @Future
    private LocalDateTime plannedStartTime;

    /* Planed Date */
    @DateTimeFormat( pattern = "MM/dd/yyyy" )
    @Future
    private LocalDate planedDate;

    @DateTimeFormat( pattern = "MM/dd/yyyy HH:mm" )
    @Future
    private LocalDateTime estimatedEndTime;

    /**
     * Status of Scheduling procedure.
     * 
     * @since 2018.05.17
     * @author annik
     */
    public static enum Status {

        PLANNED( "p" ), // 
        IN_PROGRESS( "i" ), // 
        FINISHED( "f" ) //
        ;

        private String key;

        private Status( String key ) {

            this.key = key;
        }

        public String getValue() {

            return this.key;
        }
    }

    public Integer getGid() {

        return gid;
    }

    public void setGid( Integer gid ) {

        this.gid = gid;
    }

    public Integer getPatientGid() {

        return patientGid;
    }

    public void setPatientGid( Integer patientGid ) {

        this.patientGid = patientGid;
    }

    public Integer getDoctorGid() {

        return doctorGid;
    }

    public void setDoctorGid( Integer doctorGid ) {

        this.doctorGid = doctorGid;
    }

    public Integer getRoomGid() {

        return roomGid;
    }

    public void setRoomGid( Integer roomGid ) {

        this.roomGid = roomGid;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription( String description ) {

        this.description = description;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus( Status status ) {

        this.status = status;
    }

    public LocalDateTime getPlannedStartTime() {

        return plannedStartTime;
    }

    public void setPlannedStartTime( LocalDateTime plannedStartTime ) {

        this.plannedStartTime = plannedStartTime;
    }

    public LocalDate getPlanedDate() {

        return planedDate;
    }

    public void setPlanedDate( LocalDate plannedDate ) {

        this.planedDate = plannedDate;
    }

    public LocalDateTime getEstimatedEndTime() {

        return estimatedEndTime;
    }

    public void setEstimatedEndTime( LocalDateTime estimatedEndTime ) {

        this.estimatedEndTime = estimatedEndTime;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "ScheduleForm [gid=" );
        builder.append( gid );
        builder.append( ", patientGid=" );
        builder.append( patientGid );
        builder.append( ", doctorGid=" );
        builder.append( doctorGid );
        builder.append( ", roomGid=" );
        builder.append( roomGid );
        builder.append( ", description=" );
        builder.append( description );
        builder.append( ", status=" );
        builder.append( status );
        builder.append( ", plannedStartTime=" );
        builder.append( plannedStartTime );
        builder.append( ", pd=" );
        builder.append( planedDate );
        builder.append( ", estimatedEndTime=" );
        builder.append( estimatedEndTime );
        builder.append( "]" );
        return builder.toString();
    }

}
