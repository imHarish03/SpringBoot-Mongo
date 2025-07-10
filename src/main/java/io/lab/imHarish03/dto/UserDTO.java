package io.lab.imHarish03.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	private String id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Team name is required")
	private String teamName;

	private Long salary;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
