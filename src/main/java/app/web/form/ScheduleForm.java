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
import java.time.LocalTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import app.web.model.Patient;

/**
 * Spring MVC Web form data for Scheduling procedures.
 * 
 * @since 2018.05.17
 * @author annik
 */
public class ScheduleForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer gid;

    private Integer doctorGid;

    private Integer roomGid;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private String room;

    private String[] roomTime;

    private String[] endRoomTime;

    private Status status;

    @DateTimeFormat( pattern = "MM/dd/yyyy HH:mm" )
    @Future
    private LocalDateTime plannedStartTime;

    @DateTimeFormat( pattern = "MM/dd/yyyy HH:mm" )
    @Future
    private LocalDateTime estimatedEndTime;

    private Patient patient;

    /**
     * Status of Scheduling procedure.
     * 
     * @since 2018.05.17
     * @author annik
     */
    public static enum Status {

        PLANNED( "p", "Planned" ), // 
        IN_PROGRESS( "i", "In progress" ), // 
        FINISHED( "f", "Finished" ) //
        ;

        private String key;

        private String label;

        private Status( String key, String label ) {

            this.key = key;
            this.label = label;
        }

        public String getValue() {

            return this.key;
        }

        /**
         * @return plain text this Status.
         */
        public String getLabel() {

            return this.label;
        }

        public static ScheduleForm.Status keyOf( String key ) {

            ScheduleForm.Status result = null;
            for (ScheduleForm.Status item : ScheduleForm.Status.values()) {
                if ( key.equals( item.getValue() ) ) {
                    result = item;
                }
            }
            return result == null ? PLANNED : result;
        }

    }

    public Integer getGid() {

        return gid;
    }

    public void setGid( Integer gid ) {

        this.gid = gid;
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

    public LocalDateTime getEstimatedEndTime() {

        return estimatedEndTime;
    }

    public void setEstimatedEndTime( LocalDateTime estimatedEndTime ) {

        this.estimatedEndTime = estimatedEndTime;
    }

    public String[] getRoomTime() {

        return roomTime;
    }

    public void setRoomTime( String[] roomTime ) {

        this.roomTime = roomTime;
    }

    public String[] getEndRoomTime() {

        return endRoomTime;
    }

    public void setEndRoomTime( String[] endRoomTime ) {

        this.endRoomTime = endRoomTime;
    }

    public String getRoom() {

        return room;
    }

    public void setRoom( String room ) {

        this.room = room;
    }

    public Patient getPatient() {

        return this.patient;
    }

    public void setPatient( Patient patient ) {

        this.patient = patient;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "ScheduleForm [gid=" );
        builder.append( gid );
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
        builder.append( ", estimatedEndTime=" );
        builder.append( estimatedEndTime );
        builder.append( "]" );
        return builder.toString();
    }

    /**
     * Helper method. Prepare planed and estimated time.
     * 
     * @param planedDate
     */
    public void prepareTime( LocalDate planedDate ) throws Exception {

        if ( planedDate != null ) {

            int roomIndex = Integer.parseInt( this.room );

            LocalTime startTime = LocalTime.parse( this.roomTime[roomIndex] );
            LocalTime endTime = null;
            try {
                endTime = LocalTime.parse( this.endRoomTime[roomIndex] );

            } catch (Exception e) {
                // suppose that end time is not chosen
            }

            LocalDateTime ldt = LocalDateTime.of( planedDate, startTime );
            this.setPlannedStartTime( ldt );

            if ( endTime != null && !endTime.equals( startTime ) && endTime.isAfter( startTime ) ) {

                ldt = LocalDateTime.of( planedDate, endTime );
                this.setEstimatedEndTime( ldt );
            }

        }

    }

}
