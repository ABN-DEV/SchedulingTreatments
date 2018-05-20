/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.web.model.Patient;

/**
 * MVC web controller for common URLs.
 * 
 * @since 2018.05.15
 * @author annik
 */
@Controller
public class RootController {

    @Value( "${index.message}" )
    private String message;

    /**
     * Index page.
     * 
     * @param model
     * @return the name of the template.
     */
    @GetMapping( value = {"/", "/index"} )
    public String index( Model model ) {

        model.addAttribute( "message", message );

        return "index";
    }

}
