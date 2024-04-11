package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.util.ContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BalanceService.
 *
 * @author Author
 */
@Slf4j
@Service
public class BalanceService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ContextHolder contextHolder;

    public Account change(Long id, Double diff) {
        String userInfo = contextHolder.getUserInfo();
        log.info("Пользователь " + userInfo + " изменяет баланс счёта id = " + id + " на сумму = " + diff);

        Account account = accountRepository.getOne(id);
        account.setAmount(account.getAmount() + diff);
        return accountRepository.save(account);
    }
}
