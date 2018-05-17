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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import app.web.model.Room;

/**
 * 
 * @since 2018.05.17
 * @author annik
 */
@Component( "roomService" )
public class RoomService implements IRoomService {

    @Autowired
    @Qualifier( "roomRepository" )
    private RoomRepository roomRepository;

    /*
     * (non-Javadoc)
     * @see app.web.repository.IRoomService#getAll()
     */
    @Override
    public Collection<Room> getAll() {

        return (Collection<Room>) roomRepository.findAll();

    }

    @Override
    public void initialise() {

        if ( !roomRepository.findById( 1 ).isPresent() ) {
            roomRepository.save( new Room( 1, "#1" ) );
        }
        if ( !roomRepository.findById( 2 ).isPresent() ) {
            roomRepository.save( new Room( 2, "#2" ) );
        }
        if ( !roomRepository.findById( 3 ).isPresent() ) {
            roomRepository.save( new Room( 3, "#3" ) );
        }
        if ( !roomRepository.findById( 4 ).isPresent() ) {
            roomRepository.save( new Room( 4, "#4" ) );
        }
    }

}
