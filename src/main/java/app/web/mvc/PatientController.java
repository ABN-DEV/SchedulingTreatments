/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.mvc;

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

import app.web.exception.PatientFormInvalidException;
import app.web.form.PatientForm;
import app.web.model.Patient;
import app.web.repository.IPatientService;

/**
 * MVC web controller for {@link Patient}.
 * 
 * @since 2018.05.15
 * @author annik
 */
@Controller
public class PatientController {

    private static final Logger LOG = LoggerFactory.getLogger( PatientController.class );

    @Value( "${patient.title}" )
    private String patientTitle;

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
    @GetMapping( value = {"/patientList"} )
    public String patientList( Model model, @ModelAttribute( "frmPatient" ) final PatientForm frmPatient ) {

        commonModel( model );

        model.addAttribute( "frmPatient", frmPatient );
        model.addAttribute( "patients", patientService.getAll() );

        return "patientList";
    }

    /**
     * @param model
     *            the {@link Model}
     * @param frmPatient
     * @param bindingResult
     * @return
     */
    @PostMapping( value = {"/patientList"} )
    public String addNewPatient( final Model model,
            @ModelAttribute( "frmPatient" ) @Valid final PatientForm frmPatient, //
            final BindingResult bindingResult ) {

        String resultUrl = "redirect:patientList";

        try {
            if ( bindingResult.hasErrors() ) {
                LOG.error( "Add new Patient form has error. Validation failed. {} ", frmPatient );

                // return form data to correct them
                model.addAttribute( "frmPatient", frmPatient );

                commonModel( model );

                throw new PatientFormInvalidException();

            } else {
                // no errors in Patient Web Form - the new Patient can be added
                LOG.debug( "Patient form is Valid", frmPatient );

                patientService.add( frmPatient );
            }

        } catch (Exception e) {
            LOG.error( "Patient form has error.", e );
            model.addAttribute( "error", Boolean.TRUE );
            resultUrl = "patientList";
        }

        return resultUrl;
    }

    public void commonModel( Model model ) {

        model.addAttribute( "patientTitle", patientTitle );
        model.addAttribute( "message", message );
    }

}
