/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;

import app.web.TestConfig;
import app.web.form.PatientForm;

/**
 * 
 * @since 2018.05.15
 * @author annik
 */
@RunWith( SpringJUnit4ClassRunner.class )
//@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration( classes = TestConfig.class )
public class PatientServiceTests {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    @Qualifier( "patientService" )
    private IPatientService patientService;

    private MockMvc mockMvc;

    @SuppressWarnings( "javadoc" )
    @Before
    public void init() {

        mockMvc = MockMvcBuilders.webAppContextSetup( wac )
            .build();
    }

    @SuppressWarnings( "javadoc" )
    @Test
    public void testPatientServiceIsNotNull() throws Exception {

        assertNotNull( patientService );
    }

    @SuppressWarnings( "javadoc" )
    @Test
    public void testAddNewPatient() throws Exception {

        String name = "JOHN DOE";
        String male = "m";
        String birthday = "12/01/1990";

        PatientForm patientForm = new PatientForm( name );
        patientForm.setGender( male );
//        patientForm.setBirthday( birthday );

        patientService.add( patientForm );
    }

}
