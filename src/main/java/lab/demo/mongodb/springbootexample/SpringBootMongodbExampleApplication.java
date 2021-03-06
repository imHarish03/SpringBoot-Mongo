package lab.demo.mongodb.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lab.demo.mongodb.springbootexample.service.UserService;

@SpringBootApplication
public class SpringBootMongodbExampleApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// userService.saveUser();
		// userService.getUser();

		// userService.updateUser();
		userService.updateUserImpl();
	}

}
