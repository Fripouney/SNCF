package projet.sncf.repositories;

import projet.sncf.tables.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BilletRepository extends JpaRepository<Billet, Long> {
    
    List<Billet> findByUserId(Long long1);
    Billet findByIdAndUserId(Long billetId, Long userId);
}
