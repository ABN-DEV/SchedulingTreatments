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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.web.form.PatientForm;
import app.web.model.Patient;

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

    /**
     * Index page.
     * 
     * @param model
     * @return the name of the template.
     */
    @GetMapping( value = {"/patientList"} )
    public String patientList( Model model ) {

        model.addAttribute( "patientTitle", patientTitle );

        PatientForm patientForm = new PatientForm();
        model.addAttribute( "patientForm", patientForm );

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
                model.addAttribute( "patientForm", frmPatient );

            } else {
                // no errors in Patient Web Form - the new Patient can be added
                LOG.debug( "Patient form is Valid", frmPatient );

            }

        } catch (Exception e) {
            LOG.error( "Patient form has error.", e);
        }

        return resultUrl;
    }

}
