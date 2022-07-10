package com.training.helloboot.service;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.helloboot.repo.AccountRepo;

@Service
public class AccountUserDetailService implements UserDetailsService {

	private final AccountRepo repo;

	public AccountUserDetailService(AccountRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repo.findOneByEmail(email).map(a -> User.withUsername(a.getEmail()).password(a.getPassword())
				.authorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_".concat(a.getRole().toString())))).build())
				.orElseThrow(() -> new UsernameNotFoundException(
						String.format("There is no user with this %s address", email)));

	}

}
