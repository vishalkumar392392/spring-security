package com.vishal.springcloud.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vishal.springcloud.model.User;
import com.vishal.springcloud.repository.UserRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (Objects.isNull(username)) {
			throw new UsernameNotFoundException("User not found" + username);
		}

		User user = userRepository.findByEmail(username);

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getRoles());
	}

}
