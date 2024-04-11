package com.example.demo.resource;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.BalanceService;
import com.example.demo.util.ContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AccountResource.
 *
 * @author Author
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountResource {

    private final AccountRepository accountRepository;
    private final BalanceService balanceService;
    private final ContextHolder contextHolder;

    @GetMapping(value = "/accounts/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Account add(Account account, @RequestHeader String userInfo) {
        log.info("Пользователь " + userInfo + "начал создание нового счёта " + account.getAccountNumber());
        contextHolder.setUserInfo(userInfo);

        return accountRepository.save(account);
    }

    @GetMapping(value = "/accounts/{accountNumber}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<Account> findByAccountNumber(@PathVariable("accountNumber") String accountNumber,
                                      @RequestHeader String userInfo) {
        log.info("Пользователь " + userInfo + " просматривает счёт " + accountNumber);
        contextHolder.setUserInfo(userInfo);

        return accountRepository.findByAccountNumber(accountNumber);
    }

    @PutMapping(value = "/accounts/{id}/change",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Account changeBalance(@PathVariable("id") Long id,
                          @RequestParam("diff") Double diff,
                          @RequestHeader String userInfo) {
        log.info("Пользователь " + userInfo + " запросил изменение баланса счёта id = " + id);
        contextHolder.setUserInfo(userInfo);

        return balanceService.change(id, diff);
    }
}
