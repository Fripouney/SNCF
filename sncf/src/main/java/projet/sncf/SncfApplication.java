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
	public CommandLineRunner addUsers(UserRepository repoUser, TrajetRepository repoTrajets, TrainRepository repoTrains) {
		//Ajout de quelques utilisateurs en base (exemples)
		return (args) -> {
			repoUser.save(new User("Macron", "Emmanuel", false));
			repoUser.save(new User("Zidane", "Zinedine", true));
		};
	}
}
