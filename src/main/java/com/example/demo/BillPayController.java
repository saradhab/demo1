package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//  @CrossOrigin(origins="http://localhost:3000",maxAge = 3600)
@RestController
public class BillPayController {
    @Autowired
    BillPayeeRepository billPayeeRepository;

    @GetMapping("/billpayees")

    public List<BillPayee> getAllBillPayees() {
        return billPayeeRepository.findAll();
    }

    @GetMapping("/billpayees/{payeeId}")
    public Optional<BillPayee> getAllBillPayeesById(@PathVariable(value = "payeeId") Integer payeeId) {
        return billPayeeRepository.findById(payeeId);
    }

    @PostMapping("/billpayees")
    public @Valid BillPayee createBillPayee(@Valid @RequestBody BillPayee billPayee) {
        return billPayeeRepository.save(billPayee);
    }


    @PutMapping("/billpayees/{payeeId}")
    public @Valid BillPayee UpdateBillPayee(@PathVariable(value = "payeeId") Integer payeeId, @Valid @RequestBody BillPayee billpayee)
            throws BillPayeeNotFoundException{
        BillPayee pay = billPayeeRepository.findById(payeeId).orElseThrow(() -> new BillPayeeNotFoundException(payeeId));
       pay.setPayeeAccountNumber(billpayee.getPayeeAccountNumber());
       pay.setPayeeId(billpayee.getPayeeId());
       pay.setPayeeAddress(billpayee.getPayeeAddress());
       pay.setPayeePhone(billpayee.getPayeePhone());
       pay.setUserId(billpayee.getUserId());

       BillPayee updBillPayee = billPayeeRepository.save(pay);
        return updBillPayee;
    }

    @DeleteMapping("/accounts/{payeeId}")
    public ResponseEntity<?> deleteBillPayee(@PathVariable(value = "payeeId") int payeeId) throws BillPayeeNotFoundException {
        BillPayee payee1= billPayeeRepository.findById(payeeId)
                .orElseThrow(() -> new BillPayeeNotFoundException(payeeId));

        billPayeeRepository.delete(payee1);

        return ResponseEntity.ok().build();


    }

}
