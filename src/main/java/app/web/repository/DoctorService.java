/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.web.model.Doctor;

/**
 * 
 * @since 2018.05.17
 * @author annik
 */
@Component( "doctorService" )
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    /*
     * (non-Javadoc)
     * @see app.web.repository.IRoomService#getAll()
     */
    @Override
    public Collection<Doctor> getAll() {

        return (Collection<Doctor>) doctorRepository.findAll();

    }

    @Override
    public void initialise() {

        if ( !doctorRepository.findById( 1 ).isPresent() ) {
            doctorRepository.save( new Doctor( 1, "Ahmed Ashour" ) );
        }

        if ( !doctorRepository.findById( 2 ).isPresent() ) {
            doctorRepository.save( new Doctor( 2, "Dostoevsky Nikolay" ) );
        }

        if ( !doctorRepository.findById( 3 ).isPresent() ) {
            doctorRepository.save( new Doctor( 3, "Arnold Shvarckopf" ) );
        }

        if ( !doctorRepository.findById( 4 ).isPresent() ) {
            doctorRepository.save( new Doctor( 4, "Gerbert Wells" ) );
        }

    }

    @Override
    public Optional<Doctor> getByGid( int id ) {

        return doctorRepository.findById( id );
    }

}
