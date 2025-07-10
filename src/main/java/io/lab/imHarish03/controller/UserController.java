package io.lab.imHarish03.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.lab.imHarish03.document.Users;
import io.lab.imHarish03.dto.UserDTO;
import io.lab.imHarish03.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * Create or save a new user.
	 */
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) {
		try {
			Users savedUser = userService.save(userDTO);
			LOGGER.info("User saved: {}", savedUser.getId());
			return ResponseEntity.status(201).body(savedUser);
		} catch (Exception e) {
			LOGGER.error("Error while saving user", e);
			return ResponseEntity.status(500).body("Failed to save user");
		}
	}

	/**
	 * Get user by ID.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable String id) {
		Optional<Users> userOpt = userService.findById(id);
		if (userOpt.isPresent()) {
			LOGGER.info("User found with ID: {}", id);
			return ResponseEntity.ok(userOpt.get());
		} else {
			LOGGER.warn("User not found with ID: {}", id);
			return ResponseEntity.status(404).body("User not found");
		}
	}

	/**
	 * Get all users.
	 */
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = userService.findAll();
		LOGGER.info("Fetched {} users", users.size());
		return ResponseEntity.ok(users);
	}

	/**
	 * Update user by ID.
	 */
	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody @Valid UserDTO userDTO) {
		try {
			Users updated = userService.updateUser(userDTO);
			if (updated != null) {
				LOGGER.info("User updated: {}", userDTO.getId());
				return ResponseEntity.ok(updated);
			} else {
				LOGGER.warn("Update failed, user not found: {}", userDTO.getId());
				return ResponseEntity.status(404).body("User not found");
			}
		} catch (Exception e) {
			LOGGER.error("Error while updating user", e);
			return ResponseEntity.status(500).body("Failed to update user");
		}
	}

	/**
	 * Delete user by ID.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		try {
			boolean deleted = userService.deleteUserById(id);
			if (deleted) {
				LOGGER.info("User deleted: {}", id);
				return ResponseEntity.ok("User deleted successfully");
			} else {
				LOGGER.warn("User not found for deletion: {}", id);
				return ResponseEntity.status(404).body("User not found");
			}
		} catch (Exception e) {
			LOGGER.error("Error while deleting user", e);
			return ResponseEntity.status(500).body("Failed to delete user");
		}
	}

	@GetMapping("/page")
	public ResponseEntity<Page<UserDTO>> getUsersPaginated(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<UserDTO> userPage = userService.findAll(pageable);
		return ResponseEntity.ok(userPage);
	}

}
