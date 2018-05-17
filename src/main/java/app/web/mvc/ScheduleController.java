/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.mvc;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.web.form.ScheduleForm;
import app.web.model.Patient;
import app.web.repository.IPatientService;

/**
 * MVC web controller for Scheduling. <BR />
 * This class implements Scheduling procedures.
 * 
 * @since 2018.05.17
 * @author annik
 */
@Controller
@SessionAttributes( "selectedPatient" )
public class ScheduleController {

    private static final Logger LOG = LoggerFactory.getLogger( ScheduleController.class );

    private final String urlSchedule = "schedule";

    private final String urlSchedule2 = "schedule2";

    @Value( "${schedule.title}" )
    private String scheduleTitle;

    @Value( "${index.message}" )
    private String message;

    @Autowired
    @Qualifier( "patientService" )
    IPatientService patientService;

    /**
     * Index page.
     * 
     * @param model
     * @return the name of the template.
     */
    @GetMapping( value = {"/schedule"} )
    public String schedule( final Model model,
            @ModelAttribute( "frmSchedule" ) final ScheduleForm frmSchedule ) {

        LOG.debug( "Schedule form = {} ", frmSchedule );

        commonModel( model );

        model.addAttribute( "frmSchedule", frmSchedule );

        return "schedule";
    }

    /**
     * @param model
     * @param frmSchedule
     * @param bindingResult
     * @return
     */
    @PostMapping( value = {"/schedule"} )
    public String scheduleFind( final Model model,
            @ModelAttribute( "frmSchedule" ) @Valid final ScheduleForm frmSchedule,
            final BindingResult bindingResult ) {

        String url = "redirect:" + urlSchedule2;

        try {
            commonModel( model );

            if ( bindingResult.hasErrors() ) {
                LOG.error( "Binding Form Schedule failed." );
                throw new Exception( "Shcedule binding failed." );

            } else {
                LOG.debug( "Schedule form = {} ", frmSchedule );
                model.addAttribute( "frmSchedule", frmSchedule );

                if ( frmSchedule.getPatientGid() != null ) {
                    LOG.debug( "Patient GID = {}", frmSchedule.getPatientGid() );

                    Optional<Patient> patient = patientService.getByGid( frmSchedule.getPatientGid() );

                    if ( patient.isPresent() ) {
                        // store selected patient in session
                        model.addAttribute( "selectedPatient", (Patient) patient.get() );
                        LOG.debug( "Selected Patient={}", patient.get() );
                    }
                }
            }

        } catch (Exception e) {
            LOG.error( "Schedule failed." );
            url = urlSchedule; // Previous url
        }

        return url;
    }

    /**
     * @param model
     * @param frmSchedule
     * @param request
     * @param bindingResult
     * 
     * @return
     */
    @GetMapping( value = {"/schedule2"} )
    public String scheduleRoom( final Model model,
            @ModelAttribute( "frmSchedule" ) final ScheduleForm frmSchedule, HttpServletRequest request ) {

        String url = urlSchedule2;

        commonModel( model );

        LOG.debug( "Schedule form = {} ", frmSchedule );
        model.addAttribute( "frmSchedule", frmSchedule );
        model.addAttribute( "allPatients", patientService.getAll() );

        // get selected patient which is stored at the previous STEP.
        Patient patient = (Patient) request.getSession()
            .getAttribute( "selectedPatient" );

        if ( patient != null ) {
            LOG.debug( "Patient = {}", patient );

        }

        return url;
    }

    public void commonModel( Model model ) {

        model.addAttribute( "scheduleTitle", scheduleTitle );
        model.addAttribute( "message", message );
        model.addAttribute( "allPatients", patientService.getAll() );

    }

}
