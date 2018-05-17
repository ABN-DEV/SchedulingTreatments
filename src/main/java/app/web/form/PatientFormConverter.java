/**
 * Project ..... TreatmentSchedule<br>
 * <br>
 * Author ...... Andrey.B.Nikitin<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2018-05-17<br>
 * <br>
 */
package app.web.form;

import app.web.model.Patient;

/**
 * Helper class for {@link PatientForm}, {@link Patient}.
 * 
 * @since 2018.05.17
 * @author annik
 */
public class PatientFormConverter {

    private PatientForm patientForm;

    /**
     * Contructor.
     */
    public PatientFormConverter( PatientForm patiForm ) {

        this.patientForm = patiForm;

    }

    /**
     * Converter {@link PatientForm} to {@link Patient}.
     * 
     * @return the {@link Patient} created from {@link PatientForm}.
     */
    public Patient convert() {

        Patient patient = new Patient( this.patientForm.getFullName() );
        patient.setBirthday( this.patientForm.getBirthday() );
        patient.setGender( this.patientForm.getGender() );
        patient.setGid( this.patientForm.getGid() );

        return patient;
    }

}
