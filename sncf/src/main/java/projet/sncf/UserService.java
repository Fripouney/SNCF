package projet.sncf;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public void addUser(User user) {
		repo.save(user);
	}
	
	public Optional<User> getUserById(long id) {
		return repo.findById(id);
	}
}
