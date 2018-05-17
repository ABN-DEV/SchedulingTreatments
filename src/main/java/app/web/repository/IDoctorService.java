package app.web.repository;

import java.util.Collection;

import org.springframework.stereotype.Service;

import app.web.model.Doctor;

/**
 * {@link Doctor}`s service class.
 * 
 * @since 2018.05.17
 * @author annik
 */
@Service
public interface IDoctorService {

    /**
     * @return all {@link Doctor} in the Office.
     */
    Collection<Doctor> getAll();

    /**
     * Initializer for Doctors.
     */
    void initialise();

}
