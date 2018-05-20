/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.repository;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import app.web.model.Study;

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
public class StudyServiceTests {

    private static final Logger LOG = LoggerFactory.getLogger( StudyServiceTests.class );

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    @Qualifier( "studyService" )
    private IStudyService studyService;

    private MockMvc mockMvc;

    @SuppressWarnings( "javadoc" )
    @Before
    public void init() {

        mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
    }

    @SuppressWarnings( "javadoc" )
    @Test
    public void testPatientServiceIsNotNull() throws Exception {

        assertNotNull( studyService );
    }

    @SuppressWarnings( "javadoc" )
    @Test
    public void testAddNewPatient() throws Exception {

        Iterable<Study> study = studyService.findDate( LocalDate.of( 2018, 05, 31 ) );

        LOG.debug( "Study={}", study );
    }

}
