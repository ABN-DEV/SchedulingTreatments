/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-18<br>
 * <br>
 */
package app.web.form;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.web.model.Doctor;
import app.web.model.Room;
import app.web.model.Study;
import app.web.repository.IDoctorService;
import app.web.repository.IRoomService;

/**
 * Converter {@link ScheduleForm} into {@link Study}.
 * 
 * @since 2018.05.18
 * @author annik
 */
@Component
@Scope( scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE )
public class ScheduleFormConverter {

    private ScheduleForm scheduleForm;

    @Autowired
    @Qualifier( "roomService" )
    private IRoomService roomService;

    @Autowired
    @Qualifier( "doctorService" )
    private IDoctorService doctorService;

    /**
     * Contructor.
     */
    public ScheduleFormConverter() {

    }

    /**
     * Converter {@link ScheduleForm} into {@link Study} and you can use data with DAO.
     * 
     * @return
     */
    public Study convert( ScheduleForm form ) throws Exception {

        this.scheduleForm = form;

        Study study = new Study();
        study.setPatient( this.scheduleForm.getPatient() );

        study.setDescription( this.scheduleForm.getDescription() );

        Optional<Doctor> doc = doctorService.getByGid( this.scheduleForm.getDoctorGid() );
        if ( doc.isPresent() ) {
            study.setDoc( doc.get() );
        } else {
            throw new Exception( "Doctor GID is invalid. " );
        }

        Optional<Room> room = roomService.getByGid( Integer.parseInt( this.scheduleForm.getRoom() ) );
        if ( room.isPresent() ) {
            study.setRoom( room.get() );
        } else {
            throw new Exception( "Room GID invalid. Parser to Integer failed." );
        }

        study.setStartTime( this.scheduleForm.getPlannedStartTime() );
        study.setEndTime( this.scheduleForm.getEstimatedEndTime() );

        study.setStatus( this.scheduleForm.getStatus() );

        return study;

    }
}
