package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//  @CrossOrigin(origins="http://localhost:3000",maxAge = 3600)
@RestController
public class LoanController {
    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/loans")

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/loans/{loanId}")
    public Optional<Loan> getAllLoansById(@PathVariable(value = "loanId") Integer loanId) {
        return loanRepository.findById(loanId);
    }

    @PostMapping("/loans")
    public @Valid Loan createLoan(@Valid @RequestBody Loan loan) {
        return loanRepository.save(loan);
    }


    @PutMapping("/loans/{loanId}")
    public @Valid Loan UpdateLoan(@PathVariable(value = "loanId") Integer loanId, @Valid @RequestBody Loan loan)
            throws LoanNotFoundException {
        Loan ln = loanRepository.findById(loanId).orElseThrow(() -> new LoanNotFoundException(loanId));
        ln.setLoanType(loan.getLoanType());
        ln.setLoanAmount(loan.getLoanAmount());
        ln.setLoanOpenDate(loan.getLoanOpenDate());
        loan.setAccountId(loan.getLoanId());
        loan.setLoanStatus(loan.getLoanStatus());
        loan.setUserId(loan.getUserId());
        Loan updLoan = loanRepository.save(ln);
        return updLoan;
    }

    @DeleteMapping("/loans/{loanId}")
    public ResponseEntity<?> deleteLoan(@PathVariable(value = "loanId") int loanId) throws LoanNotFoundException {
        Loan ln1= loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException(loanId));

        loanRepository.delete(ln1);

        return ResponseEntity.ok().build();


    }

}
