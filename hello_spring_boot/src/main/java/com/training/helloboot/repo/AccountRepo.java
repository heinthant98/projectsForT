package com.training.helloboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.helloboot.entity.Account;


public interface AccountRepo extends JpaRepository<Account, Long> {

	Optional<Account> findOneByEmail(String email);
}
