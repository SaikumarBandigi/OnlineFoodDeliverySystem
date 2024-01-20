package sb.OnlineFoodDeliverySystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.exception.InsufficientBalanceException;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.AccountService;
import sb.OnlineFoodDeliverySystem.service.OrderService;
import sb.OnlineFoodDeliverySystem.service.UserInfoService;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@RestController
public class OrderController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrderService orderService;


    @PostMapping("/api/saveOrder/{accountNumber}/{payAmount}")
    public ResponseEntity<String> saveOrder(@RequestBody Order order, @PathVariable String accountNumber) throws Exception {

        Account account = accountService.getAccount(accountNumber);

        double newBalance = account.getBalance() -order.getTotalAmount().doubleValue();
        account.setBalance(newBalance);
        accountService.saveAccount(account);

        try {
            if (account.getBalance() > order.getTotalAmount().doubleValue()) {
                UserInfo userInfo = order.getUser();
                order.setUser(userInfo);
                orderService.saveOrder(order);
                return ResponseEntity.ok("Order Sucessfull");
            }
        } catch (Exception ex) {
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Didn't Saved");
    }


//    @PostMapping("/api/orders/process")
//    public ResponseEntity<String> processOrder(@RequestBody Order order) {
//        try {
//
//            System.out.println("processOrder came...");
//            // Check user balance and perform payment logic
//            BigDecimal totalAmount = order.getTotalAmount();
//            UserInfo user = order.getUser();
//            BigDecimal userBalance = user.getBalance();
//
//            if (userBalance.compareTo(totalAmount) >= 0) {
//                // Sufficient balance, deduct the amount
//                user.setBalance(userBalance.subtract(totalAmount));
//                // Save the updated user and order entities
//                userInfoService.saveUserInfo(user);
//                orderService.saveOrder(order);
//                return ResponseEntity.ok("Payment successful! Order placed.");
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance.");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during order processing.");
//        }
//    }


}
