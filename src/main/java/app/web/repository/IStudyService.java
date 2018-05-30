package app.web.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.stereotype.Service;

import app.web.form.ScheduleForm;
import app.web.Status;
import app.web.model.Study;

/**
 * Schedule the treatment.
 * 
 * @since 2018.05.16
 * @author annik
 */
@Service
public interface IStudyService {

    /**
     * Save new an apointment a Doctor and Patient in the room at planned Date Time.
     * 
     * @param scheduleForm
     * @return a {@link Study}.
     * @throws Exception
     */
    Study add( ScheduleForm scheduleForm ) throws Exception;

    /**
     * Find study by date.
     * 
     * @return
     */
    Collection<Study> findDate( LocalDate date );

    /**
     * Update Status of {@link Study}.
     * 
     * @param key
     * @param status
     * @return
     */
    Study updateStatus( Integer key, Status status );

}
