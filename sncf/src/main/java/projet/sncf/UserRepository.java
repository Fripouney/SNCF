package projet.sncf;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findById(int Id);
	public List<User> findByName(String name);
	public List<User> findAdmins();
}
