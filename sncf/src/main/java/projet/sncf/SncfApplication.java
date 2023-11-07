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
            
            String adminUsername = "admin";
            if (userRepository.findByUsername(adminUsername) == null) {
                User user = new User();
                user.setUsername(adminUsername);
                user.setPassword("123");
                user.setIsAdmin(true);

                userRepository.save(user);
            }
        };
    }
}
