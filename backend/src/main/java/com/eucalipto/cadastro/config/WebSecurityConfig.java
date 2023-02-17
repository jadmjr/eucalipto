package com.eucalipto.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	final UserDetailsServiceImpl userDetailsService;
	
	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeHttpRequests()
		.antMatchers(HttpMethod.GET, "/movies/**").permitAll()
		.antMatchers(HttpMethod.POST, "/movies").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/movies/**").hasRole("ADMIN")
		.anyRequest().authenticated().and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		//auth.inMemoryAuthentication().withUser("julimar").password(passwordEncoder().encode("123")).roles("ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
