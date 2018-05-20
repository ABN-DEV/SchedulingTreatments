/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-19<br>
 * <br>
 */
package app.web;

import java.util.Collection;
import java.util.Map;

/**
 * Helper class.
 * 
 * @since 2018.05.19
 * @author annik
 */
public class Utils {

    /**
     * Checks {@link Collection} against null or size zero.
     * 
     * @param collection
     * @return true or false.
     */
    public static boolean isEmpty( Collection<?> collection ) {

        if ( collection == null || collection.size() == 0 ) {
            return true;
        }
        return false;
    }

    /**
     * Checks {@link Map} against null or size zero.
     * 
     * @param map
     * @return
     */
    public static boolean isEmpty( Map<?, ?> map ) {

        if ( map == null || map.size() == 0 ) {
            return true;
        }
        return false;
    }
}
