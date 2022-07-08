package com.training.helloboot;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig{
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
		http.authorizeRequests(auth -> auth
			.antMatchers("/", "/login","/sign-in","/sign-up", "/resources/**").permitAll()
			.antMatchers("/admin/**").hasRole("Admin")
			.antMatchers("/student/**").hasAnyRole("Admin","Student")
			.anyRequest().authenticated());
		
		http.formLogin(form -> form
			.loginPage("/sign-in")
			.loginProcessingUrl("/login")
			.usernameParameter("email")
			.passwordParameter("pass")
			.defaultSuccessUrl("/home", true));
		
		http.logout(logout -> logout
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true));
		
		return http.build();
		
	}
}
