/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-16<br>
 * <br>
 */
package app.web.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.web.form.PatientForm;
import app.web.form.PatientFormConverter;
import app.web.model.Patient;

/**
 * 
 * @since 2018.05.16
 * @author annik
 */
@Component( "patientService" )
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    /*
     * (non-Javadoc)
     * @see app.web.repository.IPatientService#add(app.web.form.PatientForm)
     */
    public Patient add( PatientForm patientForm ) {

        Patient patient = new PatientFormConverter( patientForm ).convert();

        return patientRepository.save( patient );
    }

    @Override
    public Collection<Patient> getAll() {

        return (Collection<Patient>) patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getByGid( Integer id ) {

        return patientRepository.findById( id );
    }

}
