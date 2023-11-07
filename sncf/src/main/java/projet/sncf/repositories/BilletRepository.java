package projet.sncf.repositories;

import projet.sncf.tables.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BilletRepository extends JpaRepository<Billet, Long> {
    
    // Find all billets for a specific user
    List<Billet> findByUserId(Long long1);

    // Find a specific billet with full details for a user
    // This method is not strictly necessary because JpaRepository provides one by default (findById),
    // but if you need to enforce business rules (like ensuring the user owns the billet), you could implement it.
    Billet findByIdAndUserId(Long billetId, Long userId);
}
