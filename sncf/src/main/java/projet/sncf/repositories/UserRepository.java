package projet.sncf.repositories;

import projet.sncf.tables.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    
    User findByUsernameAndPassword(String username, String password);
    
    // An admin might want to get all users for management purposes
    // This is already provided by JpaRepository.findAll(), but could be explicitly defined if needed.
}
