package com.student.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Component
public class AuthUserDetailsService implements UserDetailsService{
	
	@Autowired
	private StudentRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Student student = repo.findByEmail(username);
		if(Objects.isNull(student)) {
			throw new UsernameNotFoundException("User not found in database" + username);
		}
		return new User(username, student.getPassword(), student.getRoles());
	}

}
