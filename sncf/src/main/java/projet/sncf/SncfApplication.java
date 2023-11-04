package projet.sncf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SncfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SncfApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner addUsers(UserRepository repo) {
		return (args) -> {
			repo.save(new User("Macron", "Emmanuel", false));
			repo.save(new User("Zidane", "Zinedine", true));		
		};
	}
}
