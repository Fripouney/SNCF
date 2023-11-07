package projet.sncf.repositories;

import projet.sncf.tables.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    
    // Find all trains that are not canceled
    List<Train> findByIsCanceledFalse();

    // Find all available trains with associated trajets start and finish
    @Query("SELECT t FROM Train t JOIN FETCH t.trajets WHERE t.isCanceled = false")
    List<Train> findAvailableTrainsWithTrajets();
}
