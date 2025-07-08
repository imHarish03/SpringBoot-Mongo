package io.lab.imHarish03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lab.imHarish03.document.Users;
import io.lab.imHarish03.repository.UserDAO;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	// Accept user input from request payload and save to DB
	@PostMapping("/save")
	public String saveUser(@RequestBody Users user) {
		try {
			userDAO.save(user);
			return "User saved successfully!";
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	@GetMapping("/{id}")
	public Users getUserById(@PathVariable String id) {
		Optional<Users> userOpt = userDAO.findById(id);
		return userOpt.orElse(null); // or throw custom exception
	}
	
	@GetMapping
    public List<Users> getAllUsers() {
        return userDAO.findAll();
    }

}
