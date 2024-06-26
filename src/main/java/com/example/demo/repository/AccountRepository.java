package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AccountRepository.
 *
 * @author Author
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByAccountNumber(String accountNumber);
}