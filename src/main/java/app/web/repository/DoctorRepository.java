/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.web.model.Doctor;

/**
 * 
 * @since 2018.05.17
 * @author annik
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
