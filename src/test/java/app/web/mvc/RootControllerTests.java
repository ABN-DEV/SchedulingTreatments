/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-15<br>
 * <br>
 */
package app.web.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
 * 
 * @since 2018.05.15
 * @author annik
 */
//@RunWith( SpringJUnit4ClassRunner.class )
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration( classes = TestConfig.class )
public class RootControllerTests {

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
    public void testHomePage() throws Exception {

        mockMvc.perform( get( "/" ) )
            .andExpect( status().isOk() )
            .andExpect( view().name( "index" ) );
    }

    @SuppressWarnings( "javadoc" )
    @Test
    public void testIndexPage() throws Exception {

        mockMvc.perform( get( "/index.html" ) )
            .andExpect( status().isOk() )
            .andExpect( view().name( "index" ) );
    }

}
