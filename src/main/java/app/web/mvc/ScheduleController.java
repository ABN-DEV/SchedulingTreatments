/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.mvc;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import app.web.form.ScheduleStep1Form;
import app.web.model.Patient;
import app.web.repository.IDoctorService;
import app.web.repository.IPatientService;
import app.web.repository.IRoomService;

/**
 * MVC web controller for Scheduling. <BR />
 * This class implements Scheduling procedures.
 * 
 * @since 2018.05.17
 * @author annik
 */
@Controller
@SessionAttributes( {"selectedPatient", "frmScheduleStep1", "frmScheduleMain"} )
public class ScheduleController {

    private static final Logger LOG = LoggerFactory.getLogger( ScheduleController.class );

    private final String urlSchedule = "schedule";

    private final String urlSchedule2 = "schedule2";

    private final String urlSchedule3 = "schedule3";

    @Value( "${schedule.title}" )
    private String scheduleTitle;

    @Value( "${index.message}" )
    private String message;

    @Autowired
    @Qualifier( "patientService" )
    IPatientService patientService;

    @Autowired
    @Qualifier( "doctorService" )
    private IDoctorService doctorService;

    @Autowired
    @Qualifier( "roomService" )
    private IRoomService roomService;

    /**
     * Index page.
     * 
     * @param model
     * @return the name of the template.
     */
    @GetMapping( value = {"/schedule"} )
    public String schedule( final Model model,
            @ModelAttribute( "frmSchedule1" ) final ScheduleStep1Form frmScheduleStep1 ) {

        LOG.debug( "Schedule form = {} ", frmScheduleStep1 );

        commonModel( model );

        model.addAttribute( "frmScheduleStep1", frmScheduleStep1 );

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
            @ModelAttribute( "frmSchedule1" ) @Valid final ScheduleStep1Form frmScheduleStep1,
            final BindingResult bindingResult ) {

        String url = "redirect:" + urlSchedule2;

        try {
            commonModel( model );

            if ( bindingResult.hasErrors() ) {
                LOG.error( "Binding Form Schedule failed." );
                throw new Exception( "Shcedule binding failed." );

            } else {
                LOG.debug( "Schedule Step1 form = {} ", frmScheduleStep1 );
                model.addAttribute( "frmScheduleStep1", frmScheduleStep1 );

                if ( frmScheduleStep1.getPatientGid() != null ) {
                    LOG.debug( "Patient GID = {}", frmScheduleStep1.getPatientGid() );

                    Optional<Patient> patient = patientService.getByGid( frmScheduleStep1.getPatientGid() );

                    if ( patient.isPresent() ) {
                        // store selected patient in session
                        model.addAttribute( "selectedPatient", (Patient) patient.get() );
                        LOG.debug( "Selected Patient={}", patient.get() );
                    }
                }
            }

        } catch (Exception e) {
            LOG.error( "Schedule failed.", e );
            url = urlSchedule; // Previous url
        }

        return url;
    }

    /**
     * Show chose the Pationt, planed date. Web form for finishing scheduling.
     * 
     * @param model
     * @param frmScheduleStep1
     * @param frmSchedule
     * @param request
     * 
     * @return
     */
    @GetMapping( value = {"/schedule2"} )
    public String scheduleRoom( final Model model,
            @ModelAttribute( "frmScheduleStep1" ) final ScheduleStep1Form frmScheduleStep1,
            @ModelAttribute( "frmScheduleMain" ) final ScheduleForm frmSchedule, 
            HttpServletRequest request ) {

        String url = urlSchedule2;

        commonModel( model );

        LOG.debug( "Schedule form = {} ", frmScheduleStep1 );
        model.addAttribute( "frmScheduleStep1", frmScheduleStep1 );

        model.addAttribute( "frmScheduleMain", frmSchedule );

        // get selected patient which is stored at the previous STEP.
        Patient patient = (Patient) request.getSession().getAttribute( "selectedPatient" );

        if ( patient != null ) {
            LOG.debug( "Patient = {}", patient );
            model.addAttribute( "selectedPatient", patient );

            // show all rooms and choose a Doctor

        }

        return url;
    }

    /**
     * @param model
     * @param frmSchedule
     * @param request
     * @param bindingResult 
     * @return 
     */
    @PostMapping( value = {"/schedule2"} )
    public String makeAnApointment( final Model model,
            @ModelAttribute( "frmScheduleMain" ) @Valid final ScheduleForm frmSchedule,
            final BindingResult bindingResult, 
            HttpServletRequest request) {

        // next page 
        String url = "redirect:" + urlSchedule3;

        try {

            if ( bindingResult.hasErrors() ) {
                LOG.error( "Binding Form Schedule failed." );
                throw new Exception( "Shcedule binding failed." );

            } else {
                LOG.debug( "Schedule form = {} ", frmSchedule );

                // get selected patient which is stored at the previous STEP.
                Patient patient = (Patient) request.getSession().getAttribute( "selectedPatient" );

                ScheduleStep1Form form1 =
                    (ScheduleStep1Form) request.getSession().getAttribute( "frmScheduleStep1" );

                if ( patient != null && form1!=null) {
                    LOG.debug( "Patient = {}", patient );

                    frmSchedule.setPatientGid( patient.getGid() );
                    
                    // if STATUS is NULL - create new 
                    if ( frmSchedule.getStatus() == null ) {
                        frmSchedule.setStatus( ScheduleForm.Status.PLANNED );
                    }

                    model.addAttribute( "selectedPatient", patient );
                    model.addAttribute( "frmScheduleMain", frmSchedule );
                }else {
                    throw new Exception("Unknown Patient or Invalid form step.");
                }
            }

        } catch (Exception e) {
            LOG.error( "Schedule failed.", e );
            url = urlSchedule2; // Previous url
            
            commonModel( model );
        }

        return url;
    }

    /**
     * Lat page of schedule. Show an apointment.
     */
    @GetMapping( value = {"/schedule3"} )
    public String scheduleFinished( final Model model, HttpServletRequest request ) {

        String url = urlSchedule3;

        commonModel( model );

        // get selected patient which is stored at the previous STEP.
        Patient patient = (Patient) request.getSession().getAttribute( "selectedPatient" );

        ScheduleForm frmSchedule = (ScheduleForm) request.getSession().getAttribute( "frmScheduleMain" );
        model.addAttribute( "frmSchedule", frmSchedule );

        ScheduleStep1Form form1 = (ScheduleStep1Form) request.getSession().getAttribute( "frmScheduleStep1" );

        if ( patient != null && form1 != null && frmSchedule != null ) {
            LOG.debug( "Patient = {}", patient );
            model.addAttribute( "selectedPatient", patient );

            // show all rooms and choose a Doctor

        } else {
            // get back to start of scheduling
            url = "redirect:" + urlSchedule;
        }

        return url;
    }

    /**
     * Create all time slots with period 15 minutes.
     * 
     * @return
     */
    private Collection<LocalTime> getAllTimeSlots() {

        Integer[] mm = {0, 15, 30, 45};
        List<Integer> listMinutes = new ArrayList<>( Arrays.asList( mm ) );

        Collection<LocalTime> timeSlots = new ArrayList<>();

        for (int i = 8; i < 23; i++) {

            final int k = i;
            Arrays.asList( mm ).stream().map( t -> LocalTime.of( k, t.intValue() ) ).forEach(
                t -> timeSlots.add( t ) );
        }

        return timeSlots;
    }

    public void commonModel( Model model ) {

        model.addAttribute( "scheduleTitle", scheduleTitle );
        model.addAttribute( "message", message );
        model.addAttribute( "allPatients", patientService.getAll() );
        model.addAttribute( "allDoctors", doctorService.getAll() );
        model.addAttribute( "allRooms", roomService.getAll() );
        model.addAttribute( "allTimeSlots", getAllTimeSlots() );


    }

}
