package app.web;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TreatmentScheduleApplication {

    private static final Logger LOG = LoggerFactory.getLogger( TreatmentScheduleApplication.class );

    public static void main( String[] args ) {

//        H2DbManager h2Server = new H2DbManager();
//        try {
//            h2Server.startTcpServer();

            ConfigurableApplicationContext ctx =
                SpringApplication.run( TreatmentScheduleApplication.class, args );

//            h2Server.startTcpServer();
//        } catch (SQLException e) {
//            LOG.error( "Starting the Application failed.", e );
//        }
    }
}
