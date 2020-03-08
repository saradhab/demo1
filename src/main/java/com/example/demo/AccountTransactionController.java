package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//  @CrossOrigin(origins="http://localhost:3000",maxAge = 3600)
@RestController
public class AccountTransactionController {
    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @GetMapping("/transactions")

    public List<AccountTransaction> getAllTransactions() {
        return accountTransactionRepository.findAll();
    }

    @GetMapping("/transactions{accountId}")
    public Optional<AccountTransaction> getAllTransactionsById(@PathVariable(value = "accountId") Integer accountId) {
        return accountTransactionRepository.findById(accountId);
    }

    @PostMapping("/transactions")
    public @Valid AccountTransaction createTransaction(@Valid @RequestBody AccountTransaction transaction) {
        return accountTransactionRepository.save(transaction);
    }


    @PutMapping("/transactions/{accountId}")
    public AccountTransaction UpdateTransaction(@PathVariable(value = "accountId") Integer accountId, @Valid @RequestBody AccountTransaction transaction)
            throws  AccountTransactionNotFoundException {
        AccountTransaction trs = accountTransactionRepository.findById(accountId).orElseThrow(() -> new AccountTransactionNotFoundException(accountId));
        trs.setTransactionNumber(transaction.getTransactionNumber());
        trs.setAccountId(transaction.getAccountId());
        trs.setTransactionDate(transaction.getTransactionDate());
        trs.setTransactionAccount(transaction.getTransactionAccount());
        trs.setTransactionType(transaction.getTransactionType());
        trs.setLoanId(transaction.getLoanId());
        trs.setPayeeId(transaction.getPayeeId());

        AccountTransaction updTransaction = accountTransactionRepository.save(trs);
        return updTransaction ;
    }

    @DeleteMapping("/transactions/{accountId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "accountId") int accountId) throws AccountTransactionNotFoundException {
        AccountTransaction trs1 = accountTransactionRepository.findById(accountId)
                .orElseThrow(() -> new AccountTransactionNotFoundException(accountId));

        accountTransactionRepository.delete(trs1);

        return ResponseEntity.ok().build();


    }

}
