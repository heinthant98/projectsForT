package com.training.helloboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.training.helloboot.entity.Account;
import com.training.helloboot.entity.Account.Role;
import com.training.helloboot.repo.AccountRepo;

@Component
public class UserInitializer {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AccountRepo accountRepo;
	
	@Transactional
	@EventListener(classes = ContextRefreshedEvent.class)
	public void initializeUser() {
		if(accountRepo.count() == 0) {
			var account = new Account();
			account.setEmail("admin@gmail.com");
			account.setName("Admin");
			account.setRole(Role.Admin);
			account.setPassword(passwordEncoder.encode("admin"));
			accountRepo.save(account);
		}
	}
	

}
