package projet.sncf.repositories;

import projet.sncf.tables.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    
    User findByUsernameAndPassword(String username, String password);
}
 
