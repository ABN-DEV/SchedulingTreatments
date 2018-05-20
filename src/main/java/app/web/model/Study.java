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
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import app.web.form.ScheduleForm;

/**
 * Domain object a Doctor.
 * 
 * @since 2018.05.17
 * @author annik
 */
@Entity
@Table( name = "study" )
public class Study implements Serializable {

    @Id
    @GeneratedValue
    @Column( nullable = false, unique = true )
    private Integer gid;

    @Column( length = 250, nullable = false )
    private String Description;

    @Column( length = 1, nullable = false )
    private ScheduleForm.Status Status;

    @Column( nullable = false )
    private LocalDateTime startTime;

    @Column( nullable = true )
    private LocalDateTime endTime;

    @ManyToOne( )
    @JoinColumn( name = "patientId", referencedColumnName = "gid" )
    private Patient patient;

    @ManyToOne( )
    @JoinColumn( name = "doctorId", referencedColumnName = "gid" )
    private Doctor doc;

    @ManyToOne( )
    @JoinColumn( name = "roomId", referencedColumnName = "gid" )
    private Room room;

    public Integer getGid() {

        return gid;
    }

    public void setGid( Integer gid ) {

        this.gid = gid;
    }

    public String getDescription() {

        return Description;
    }

    public void setDescription( String description ) {

        Description = description;
    }

    public ScheduleForm.Status getStatus() {

        return Status;
    }

    public void setStatus( ScheduleForm.Status status ) {

        Status = status;
    }

    public LocalDateTime getStartTime() {

        return startTime;
    }

    public void setStartTime( LocalDateTime startTime ) {

        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {

        return endTime;
    }

    public void setEndTime( LocalDateTime endTime ) {

        this.endTime = endTime;
    }

    public Patient getPatient() {

        return patient;
    }

    public void setPatient( Patient patient ) {

        this.patient = patient;
    }

    public Doctor getDoc() {

        return doc;
    }

    public void setDoc( Doctor doc ) {

        this.doc = doc;
    }

    public Room getRoom() {

        return room;
    }

    public void setRoom( Room room ) {

        this.room = room;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "Study [gid=" );
        builder.append( gid );
        builder.append( ", Description=" );
        builder.append( Description );
        builder.append( ", Status=" );
        builder.append( Status );
        builder.append( ", startTime=" );
        builder.append( startTime );
        builder.append( ", endTime=" );
        builder.append( endTime );
        builder.append( ", patient=" );
        builder.append( patient );
        builder.append( ", doc=" );
        builder.append( doc );
        builder.append( ", room=" );
        builder.append( room );
        builder.append( "]" );
        return builder.toString();
    }

}
