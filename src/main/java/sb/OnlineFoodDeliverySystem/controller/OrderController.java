package sb.OnlineFoodDeliverySystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.OrderService;
import sb.OnlineFoodDeliverySystem.service.UserInfoService;

import java.math.BigDecimal;

@RestController
public class OrderController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrderService orderService;


    @PostMapping("/api/saveOrder")
    public ResponseEntity<String> saveOrder(@RequestBody Order order) {

        Order orderSaved = orderService.saveOrder(order);
        if (orderSaved != null) {
            return ResponseEntity.ok("Order Saved Successfully..");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error");

    }


    @PutMapping("/api/UpdateOrder")
    public ResponseEntity<String> UpdateOrder(@RequestBody Order order) {


        Order presentOrder = orderService.getOrderById(order.getId());

        if (presentOrder != null) {
            presentOrder.setOrderDate(order.getOrderDate());
            presentOrder.setTotalAmount(order.getTotalAmount());
            presentOrder.setUser(order.getUser());
            orderService.saveOrder(presentOrder);
        }

        return ResponseEntity.ok("Updated Succesfully.....");
    }


    @PostMapping("/api/orders/process")
    public ResponseEntity<String> processOrder(@RequestBody Order order) {
        try {

            System.out.println("processOrder came...");
            // Check user balance and perform payment logic
            BigDecimal totalAmount = order.getTotalAmount();
            UserInfo user = order.getUser();
            BigDecimal userBalance = user.getBalance();

            if (userBalance.compareTo(totalAmount) >= 0) {
                // Sufficient balance, deduct the amount
                user.setBalance(userBalance.subtract(totalAmount));
                // Save the updated user and order entities
                userInfoService.saveUserInfo(user);
                orderService.saveOrder(order);
                return ResponseEntity.ok("Payment successful! Order placed.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during order processing.");
        }
    }


}
