package app.web.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.web.model.Study;

/**
 * 
 * @since 2018.05.18
 * @author annik
 */
@Repository
public interface IStudyRepository extends CrudRepository<Study, Integer> {

    /**
     * Find all appointments at the day
     * 
     * @param date
     * @param plusDays
     */
    List<Study> findByStartTimeBetween( LocalDateTime date, LocalDateTime plusDays );

    /**
     * @param date
     * @param plusDays
     * @return
     */
//    List<Study> findByStartTimeGreaterThanEqualAndByStartTimeLessThanEqual( LocalDateTime date,
//            LocalDateTime plusDays );

    /**
     * @param date
     * @param plusDays
     * @return
     */
    List<Study> findByStartTimeAfterAndStartTimeBefore( LocalDateTime date, LocalDateTime plusDays );

    Collection<Study> findByStartTimeAfter( LocalDateTime date );

}
