package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.modal.LoginModel;
import com.student.modal.StudentModel;
import com.student.security.AuthUtil;
import com.student.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthUtil authUtil;

	@GetMapping("/getAllStudents")
	public List<StudentModel> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping("/register")
	public String register(@RequestBody StudentModel student) {
		return studentService.save(student);

	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody LoginModel loginModel) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getUsername(), loginModel.getPassword()));

			final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUsername());
			return authUtil.generateToken(userDetails);
		} catch (Exception ex) {
			throw new Exception("invalid credentials");
		}

	}

	@DeleteMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		return studentService.deleteStudent(id);
	}
}
