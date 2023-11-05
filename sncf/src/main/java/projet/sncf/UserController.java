package projet.sncf;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public void addUser(User user) {
		userService.addUser(user);
	}
	
	public Optional<User> getUserById(long id) {
		return userService.getUserById(id);
	}
}
