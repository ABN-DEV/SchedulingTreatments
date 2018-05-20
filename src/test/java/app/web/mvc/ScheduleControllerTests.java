/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import app.web.TestConfig;

/**
 * Test for ScheduleController.
 * 
 * @since 2018.05.17
 * @author annik
 */
@RunWith( SpringJUnit4ClassRunner.class )
//@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration( classes = TestConfig.class )
public class ScheduleControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @SuppressWarnings( "javadoc" )
    @Before
    public void init() {

        mockMvc = MockMvcBuilders.webAppContextSetup( wac )
            .build();
    }

    @SuppressWarnings( "javadoc" )
    @Test
    public void testSchedulePage() throws Exception {

        mockMvc.perform( get( "/schedule.html" ) )
            .andExpect( status().isOk() )
            .andExpect( view().name( "schedule" ) );
    }

}
