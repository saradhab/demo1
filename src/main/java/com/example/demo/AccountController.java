package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//  @CrossOrigin(origins="http://localhost:3000",maxAge = 3600)
@RestController
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{accountId}")
    public Optional<Account> getAllUsersById(@PathVariable(value = "accountId") Integer accountId) {
        return accountRepository.findById(accountId);
    }

    @PostMapping("/accounts")
    public @Valid Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }


    @PutMapping("/accounts/{accountId}")
    public @Valid Account UpdateAccount(@PathVariable(value = "accountId") Integer accountId, @Valid @RequestBody Account account)
            throws AccountNotFoundException {
        Account act = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        act.setAccountName(account.getAccountName());
        act.setAccountAddress(account.getAccountAddress());
        act.setAccountId(account.getAccountId());
        act.setEmail(account.getEmail());
        act.setAccountType(account.getAccountType());
        act.setAccountStatus(account.getAccountStatus());
        act.setMobileNumber(account.getMobileNumber());
        act.setDateOpen(account.getDateOpen());
        act.setDateClosed(account.getDateClosed());
        Account updAccount = accountRepository.save(act);
        return updAccount;
    }

    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "accountId") int accountId) throws AccountNotFoundException {
        Account act1= accountRepository.findById(accountId)
        .orElseThrow(() -> new AccountNotFoundException(accountId));

        accountRepository.delete(act1);

        return ResponseEntity.ok().build();


        }

}

