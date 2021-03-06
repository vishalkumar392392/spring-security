package com.vishal.security.firstapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.vishal.security.firstapp.security.AuthFilter;
import com.vishal.security.firstapp.security.AuthProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private AuthProvider authenticationProvider;
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { System.out.println("SecurityConfig"); InMemoryUserDetailsManager
	 * userDetailsService = new InMemoryUserDetailsManager(); UserDetails user =
	 * User.withUsername("vishal").password(passwordEncoder.encode("vishal")).
	 * authorities("read").build(); userDetailsService.createUser(user);
	 * auth.userDetailsService(userDetailsService); }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().antMatchers("/hello").authenticated().antMatchers("/bye").denyAll();
		http.addFilterBefore(new AuthFilter(), BasicAuthenticationFilter.class);
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
