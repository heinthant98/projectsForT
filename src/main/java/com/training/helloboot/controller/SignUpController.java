package com.training.helloboot.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.helloboot.entity.Account;
import com.training.helloboot.entity.Account.Role;
import com.training.helloboot.repo.AccountRepo;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

	private final BCryptPasswordEncoder passwordEncoder;

	private final AccountRepo repo;

	public SignUpController(BCryptPasswordEncoder passwordEncoder, AccountRepo repo) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.repo = repo;
	}

	@GetMapping
	public String index() {
		return "/sign-up";
	}

	@PostMapping
	public String signUp(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			HttpServletRequest req) {

		try {
			Account acc = new Account();
			acc.setName(name);
			acc.setEmail(email);
			acc.setPassword(passwordEncoder.encode(password));
			acc.setRole(Role.Student);

			repo.save(acc);

			req.login(email, password);
		} catch (ServletException e) {
			e.printStackTrace();
		}

		return "redirect:/home";
	}
}
