/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-30<br>
 * <br>
 */
package app.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link Utils}.
 * 
 * @since 2018.05.30
 * @author annik
 */
public class UtilsTest {

    /**
     * Test method for {@link app.web.Utils#isEmpty(java.util.Collection)}.
     */
    @Test
    public void testIsEmptyCollectionNullOrEmpty() {

        Collection<String> collection = null;
        assertTrue( Utils.isEmpty( collection ) );

        collection = new ArrayList<String>();
        assertTrue( Utils.isEmpty( collection ) );

        collection.add( "test" );
        assertFalse( Utils.isEmpty( collection ) );
    }

    /**
     * Test method for {@link app.web.Utils#isEmpty(java.util.Map)}.
     */
    @Test
    public void testIsEmptyMapNullOrEmpty() {

        Map<String, String> map = null;
        assertTrue( Utils.isEmpty( map ) );

        map = new HashMap<String, String>();
        assertTrue( Utils.isEmpty( map ) );

        map.put( "key", "value" );
        assertFalse( Utils.isEmpty( map ) );

    }

}
