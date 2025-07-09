package io.lab.imHarish03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.lab.imHarish03.document.Users;
import io.lab.imHarish03.repository.UserDAO;
import io.lab.imHarish03.repository.UserDAOImpl;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserDAO userDAO;
	private final UserDAOImpl userDaoImpl;

	/**
	 * Save or create a user.
	 */
	public Users save(Users user) {
		return userDAO.save(user);
	}

	/**
	 * Find user by ID.
	 */
	public Optional<Users> findById(String id) {
		return userDAO.findById(id);
	}

	/**
	 * Return all users.
	 */
	public List<Users> findAll() {
		return userDAO.findAll();
	}

	/**
	 * Update a user if they exist.
	 */
	public Users updateUser(Users user) {
		Optional<Users> existingUser = userDAO.findById(user.getId());
		if (existingUser.isPresent()) {
			Users info = existingUser.get();
			info.setName(user.getName());
			info.setTeamName(user.getTeamName());
			info.setSalary(user.getSalary());
			return userDAO.save(info);
		} else {
			return null;
		}
	}

	/**
	 * Delete a user by ID.
	 */
	public boolean deleteUserById(String id) {
		if (userDAO.existsById(id)) {
			userDAO.deleteById(id);
			return true;
		}
		return false;
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
