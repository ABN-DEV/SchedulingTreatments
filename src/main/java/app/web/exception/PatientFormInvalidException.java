/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.exception;

/**
 * 
 * @since 2018.05.17
 * @author annik
 */
public class PatientFormInvalidException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Contructor.
     */
    public PatientFormInvalidException() {

        super();
    }

    /**
     * Contructor.
     * 
     * @param message
     */
    public PatientFormInvalidException( String message ) {

        super( message );
    }

    /**
     * Contructor.
     * 
     * @param message
     * @param cause
     */
    public PatientFormInvalidException( String message, Throwable cause ) {

        super( message,
            cause );
    }

    /**
     * Contructor.
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writeableStackTrace
     */
    public PatientFormInvalidException( String message, Throwable cause, boolean enableSuppression,
            boolean writeableStackTrace ) {

        super( message,
            cause,
            enableSuppression,
            writeableStackTrace );
    }

}
