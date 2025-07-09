package io.lab.imHarish03.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Team name is required")
	private String teamName;

	private Long salary;
}
