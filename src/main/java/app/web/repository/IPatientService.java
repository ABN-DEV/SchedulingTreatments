package app.web.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.web.exception.PatientFormInvalidException;
import app.web.form.PatientForm;
import app.web.model.Patient;

/**
 * 
 * 
 * @since 2018.05.16
 * @author annik
 */
@Service
public interface IPatientService {

    /**
     * Add new {@link Patient} from form into DB.
     * 
     * @param patientForm
     * @return created {@link Patient}
     * @throws PatientFormInvalidException
     */
    Patient add( PatientForm patientForm ) throws PatientFormInvalidException;

    /**
     * @return All {@link Patient}s.
     */
    Collection<Patient> getAll();

    /**
     * Find {@link Patient} by Gid.
     * 
     * @param integer
     * @return
     */
    Optional<Patient> getByGid( Integer integer );

}
