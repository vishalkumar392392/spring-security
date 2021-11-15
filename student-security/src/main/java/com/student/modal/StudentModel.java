package com.student.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentModel {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int role;
}
