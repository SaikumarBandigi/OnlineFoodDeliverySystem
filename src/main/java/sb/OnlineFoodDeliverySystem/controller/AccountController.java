package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


//    @PostMapping("/saveAccount")
//    public Account saveAccount(@RequestBody Account account) {
//        System.out.println("came");
//        return accountService.saveAccount(account);
//    }


}
