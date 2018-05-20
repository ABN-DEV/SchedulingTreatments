/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-16<br>
 * <br>
 */
package app.web.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.web.form.ScheduleForm;
import app.web.form.ScheduleForm.Status;
import app.web.form.ScheduleFormConverter;
import app.web.model.Study;

/**
 * 
 * @since 2018.05.16
 * @author annik
 */
@Component( "studyService" )
public class StudyService implements IStudyService {

    @Autowired
    private IStudyRepository studyRepository;

    @Autowired
    private ScheduleFormConverter scheduleFormConverter;

    /*
     * (non-Javadoc)
     * @see app.web.repository.IPatientService#add(app.web.form.PatientForm)
     */
    @Override
    public Study add( ScheduleForm scheduleForm ) throws Exception {

        Study study = scheduleFormConverter.convert( scheduleForm );

        return studyRepository.save( study );
    }

    /**
     * @return
     */
    @Override
    public Collection<Study> findDate( LocalDate date ) {

        LocalDateTime ldt = LocalDateTime.of( date, LocalTime.of( 0, 0 ) );

        return studyRepository.findByStartTimeAfterAndStartTimeBefore( ldt, ldt.plusDays( 1 ) );
    }

    /*
     * (non-Javadoc)
     * @see app.web.repository.IStudyService#updateStatus(java.lang.Integer, app.web.form.ScheduleForm.Status)
     */
    @Override
    public Study updateStatus( Integer key, Status newStatus ) {

        Optional<Study> old = studyRepository.findById( key );
        Study s = null;
        if ( old.isPresent() ) {
            Study study = old.get();
            study.setStatus( newStatus );
            s = studyRepository.save( study );
        }
        return s;
    }

}
