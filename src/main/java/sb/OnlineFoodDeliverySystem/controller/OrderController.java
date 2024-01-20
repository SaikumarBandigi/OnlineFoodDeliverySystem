package sb.OnlineFoodDeliverySystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.exception.InsufficientBalanceException;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.AccountService;
import sb.OnlineFoodDeliverySystem.service.OrderService;
import sb.OnlineFoodDeliverySystem.service.UserInfoService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
public class OrderController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrderService orderService;


    @PostMapping("/api/saveOrder/{accountNumber}")
    public ResponseEntity<String> saveOrder(@RequestBody MenuItem menuItem, @PathVariable String accountNumber) throws Exception {

        Account account = accountService.getAccount(accountNumber);

        Double balance = account.getBalance() - menuItem.getPrice().doubleValue();
        account.setBalance(balance);

        accountService.saveAccount(account);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(menuItem.getPrice());
        order.setUser(account.getUserInfo());
        orderService.saveOrder(order);

        return ResponseEntity.ok("Ok");
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
