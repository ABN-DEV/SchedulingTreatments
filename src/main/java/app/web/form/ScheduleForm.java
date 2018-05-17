/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.form;

import java.time.LocalDateTime;

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

    private LocalDateTime plannedStartTime;

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

    /**
     * Getter.
     * 
     * @return the gid
     */
    public Integer getGid() {

        return gid;
    }

    /**
     * Setter.
     * 
     * @param gid
     *            the gid to set
     */
    public void setGid( Integer gid ) {

        this.gid = gid;
    }

    /**
     * Getter.
     * 
     * @return the patientGid
     */
    public Integer getPatientGid() {

        return patientGid;
    }

    /**
     * Setter.
     * 
     * @param patientGid
     *            the patientGid to set
     */
    public void setPatientGid( Integer patientGid ) {

        this.patientGid = patientGid;
    }

    /**
     * Getter.
     * 
     * @return the description
     */
    public String getDescription() {

        return description;
    }

    /**
     * Setter.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription( String description ) {

        this.description = description;
    }

    /**
     * Getter.
     * 
     * @return the status
     */
    public Status getStatus() {

        return status;
    }

    /**
     * Setter.
     * 
     * @param status
     *            the status to set
     */
    public void setStatus( Status status ) {

        this.status = status;
    }

    /**
     * Getter.
     * 
     * @return the plannedStartTime
     */
    public LocalDateTime getPlannedStartTime() {

        return plannedStartTime;
    }

    /**
     * Setter.
     * 
     * @param plannedStartTime
     *            the plannedStartTime to set
     */
    public void setPlannedStartTime( LocalDateTime plannedStartTime ) {

        this.plannedStartTime = plannedStartTime;
    }

    /**
     * Getter.
     * 
     * @return the estimatedEndTime
     */
    public LocalDateTime getEstimatedEndTime() {

        return estimatedEndTime;
    }

    /**
     * Setter.
     * 
     * @param estimatedEndTime
     *            the estimatedEndTime to set
     */
    public void setEstimatedEndTime( LocalDateTime estimatedEndTime ) {

        this.estimatedEndTime = estimatedEndTime;
    }

    /**
     * Getter.
     * 
     * @return the doctorGid
     */
    public Integer getDoctorGid() {

        return doctorGid;
    }

    /**
     * Setter.
     * 
     * @param doctorGid
     *            the doctorGid to set
     */
    public void setDoctorGid( Integer doctorGid ) {

        this.doctorGid = doctorGid;
    }

    /**
     * Getter.
     * 
     * @return the roomGid
     */
    public Integer getRoomGid() {

        return roomGid;
    }

    /**
     * Setter.
     * 
     * @param roomGid
     *            the roomGid to set
     */
    public void setRoomGid( Integer roomGid ) {

        this.roomGid = roomGid;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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
        builder.append( ", estimatedEndTime=" );
        builder.append( estimatedEndTime );
        builder.append( "]" );
        return builder.toString();
    }

}
