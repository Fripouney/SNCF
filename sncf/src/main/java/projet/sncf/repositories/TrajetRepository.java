package projet.sncf.repositories;

import projet.sncf.tables.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    
    List<Trajet> findByStartAndFinish(String start, String finish);

    @Query("SELECT tj FROM Trajet tj JOIN tj.trains tr WHERE tr.id = :trainId")
    List<Trajet> findTrajetsByTrainId(Long trainId);
}

