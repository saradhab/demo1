package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//  @CrossOrigin(origins="http://localhost:3000",maxAge = 3600)
@RestController
public class UserAccountController {
    @Autowired
  UserAccountRepository userAccountRepository;

    @GetMapping("/useraccounts")

    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    @GetMapping("/useraccounts/{userId}")
    public Optional<UserAccount> getAllUserAccountsById(@PathVariable(value = "userId") Integer userId) {
        return userAccountRepository.findById(userId);
    }

    @PostMapping("/useraccounts")
    public @Valid UserAccount createUserAccount(@Valid @RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }


    @PutMapping("/useraccounts/{userId}")
    public @Valid UserAccount UpdateAccount(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody UserAccount userAccount)
            throws UserNotFoundException {
        UserAccount act = userAccountRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        act.setAccountId(userAccount.getAccountId());
        act.setUserId(userAccount.getUserId());

        UserAccount updUserAccount = userAccountRepository.save(act);
        return updUserAccount;
    }

    @DeleteMapping("/useraccounts/{userId}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "userId") int userId) throws UserAccountNotFoundException {
        UserAccount act1= userAccountRepository.findById(userId)
                .orElseThrow(() -> new UserAccountNotFoundException(userId));

        userAccountRepository.delete(act1);

        return ResponseEntity.ok().build();


    }

}
