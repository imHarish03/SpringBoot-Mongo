package lab.demo.mongodb.springbootexample.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.demo.mongodb.springbootexample.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void saveUser() {
		try {
			Users user = new Users(1, "Mathi", "Java Developer", 3000L);
			userDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
