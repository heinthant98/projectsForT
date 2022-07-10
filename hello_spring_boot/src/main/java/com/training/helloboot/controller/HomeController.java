package com.training.helloboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.helloboot.entity.Account.Role;
import com.training.helloboot.repo.AccountRepo;

@Controller
@RequestMapping("/home")
public class HomeController {

	private AccountRepo accountRepo;
		
	public HomeController(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@GetMapping
	public String index(HttpServletRequest req) {
		var loginId = req.getRemoteUser();
		var account = accountRepo.findOneByEmail(loginId);
		return account
				.map(a -> {
					req.getSession().setAttribute("loginUser", a);
					return a.getRole() == Role.Admin ? "redirect:/admin/home" : "redirect:/student/home"; 
				})
				.orElseThrow(() -> new UsernameNotFoundException("Illegal User"));
		
	}
}
