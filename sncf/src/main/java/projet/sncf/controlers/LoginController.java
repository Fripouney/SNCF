package projet.sncf.controlers;

import projet.sncf.repositories.*;
import projet.sncf.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String performLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("user", user); // Log in the user by adding the user object to the session
            return "redirect:/"; // Redirect to the home page or user dashboard
        } else {
            return "login"; // Stay on the login page
        }
    }
}
