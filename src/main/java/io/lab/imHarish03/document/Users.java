package io.lab.imHarish03.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Users {

	@Id
	private String  id;
	private String name;
	private String teamName;
	private Long salary;

	

}
