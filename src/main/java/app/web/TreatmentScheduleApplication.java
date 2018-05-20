package app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @since 2018.05.20
 * @author annik
 */
@SpringBootApplication
@ComponentScan( basePackages = {"app.web"} )
public class TreatmentScheduleApplication {

    private static final Logger LOG = LoggerFactory.getLogger( TreatmentScheduleApplication.class );

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main( String[] args ) {

        ConfigurableApplicationContext ctx =
            SpringApplication.run( TreatmentScheduleApplication.class, args );

    }

}
