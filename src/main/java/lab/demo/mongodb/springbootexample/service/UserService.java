package lab.demo.mongodb.springbootexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.demo.mongodb.springbootexample.document.Users;
import lab.demo.mongodb.springbootexample.repository.UserDAO;
import lab.demo.mongodb.springbootexample.repository.UserDAOImpl;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserDAOImpl userDaoImpl;

	public void saveUser() {
		try {
			Users user = new Users(1, "Mathi", "Java Developer", 3000L);
			userDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getUser() {
		List<Users> tempUserList = userDAO.findAll();

		for (Users tempUser : tempUserList) {
			System.out.println(tempUser.toString());
		}
	}

	public void updateUser() {
		try {
			Users user = new Users(1, "Hariharan", "Java Developer", 4000L);
			userDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateUserImpl() {
		userDaoImpl.updateUser();
	}

}
