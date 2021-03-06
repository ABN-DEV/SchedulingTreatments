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

import app.web.model.Room;

/**
 * 
 * @since 2018.05.17
 * @author annik
 */
public interface RoomRepository extends CrudRepository<Room, Integer> {

}
