/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @since 2018.05.17
 * @author annik
 */
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    @Qualifier( "roomService" )
    private IRoomService roomService;

    @Autowired
    @Qualifier( "doctorService" )
    private IDoctorService doctorService;

    public void run( ApplicationArguments args ) {

        roomService.initialise();

        doctorService.initialise();
    }
}