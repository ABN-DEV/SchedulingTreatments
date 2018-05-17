package app.web.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.web.model.Room;

/**
 * Service for {@link Room}.
 * 
 * @since 2018.05.17
 * @author annik
 */
@Service
public interface IRoomService {

    /**
     * @return All rooms in the office.
     */
    Collection<Room> getAll();

    /**
     * Initialized rooms.
     */
    void initialise();

}
