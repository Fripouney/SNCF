package projet.sncf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projet.sncf.repositories.UserRepository;
import projet.sncf.tables.User;

@SpringBootApplication
public class SncfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SncfApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            // Check if admin user already exists to prevent duplicate entries
            String adminUsername = "admin";
            if (userRepository.findByUsername(adminUsername) == null) {
                // Create an admin user instance
                User user = new User();
                user.setUsername(adminUsername);
                user.setPassword("123");
                user.setIsAdmin(true);

                // Save the user to the database
                userRepository.save(user);
            }
        };
    }
}
