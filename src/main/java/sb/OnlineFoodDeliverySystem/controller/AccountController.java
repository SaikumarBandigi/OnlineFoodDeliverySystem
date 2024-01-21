package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.service.AccountService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/saveAccount")
    public Account saveAccount(@RequestBody Account account) {
        System.out.println("came");
        return accountService.saveAccount(account);
    }

    @GetMapping("/getParticularAccount/{id}")
    public ResponseEntity<Account> getParticularAccount(@PathVariable Long id) {
        Account account = null;
        try {
            account = accountService.getAccountById(id);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }


}
