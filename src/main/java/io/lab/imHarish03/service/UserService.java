package io.lab.imHarish03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lab.imHarish03.document.Users;
import io.lab.imHarish03.repository.UserDAO;
import io.lab.imHarish03.repository.UserDAOImpl;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserDAOImpl userDaoImpl;

	public void saveUser() {
		try {
			Users user = new Users();
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
			Users user = new Users();
			userDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateUserImpl() {
		userDaoImpl.updateUser();
	}

}
