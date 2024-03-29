package sb.OnlineFoodDeliverySystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.Repository.AccountDao;
import sb.OnlineFoodDeliverySystem.model.*;
import sb.OnlineFoodDeliverySystem.service.impl.AccountServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.DeliveryServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.OrderServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.UserInfoServiceImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private DeliveryServiceImpl DeliveryService;


    @PostMapping("/saveOrder/{userId}")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order, @PathVariable Long userId) {
        try {
            // since user is related to order and if he wants to order he should do payment
            UserInfo userInfo = userInfoService.getUserById(userId);
            order.setUser(userInfo);

            Order newOrder = orderService.saveOrder(order);

            if (newOrder != null) {
                Account account = accountService.getAccountByUserInfo(userInfo);
                Double dbBalance = account.getBalance();

                if (dbBalance > newOrder.getTotalAmount().doubleValue()) {

                    // if the order gets success orderamount in order and the balance amount from account gets deducted...

                    Double presentBalance = dbBalance - newOrder.getTotalAmount().doubleValue();
                    accountService.updateAccountBalance(presentBalance, account);


                    // when the order gets successful,it won't be delivered at that very fast so as of now save with null and not delivered

// when delivery gets success there another api in DeliveryController to update the details
                    Delivery delivery = new Delivery();
                    delivery.setDeliveryDate(null);
                    delivery.setStatus("Not Delivered");
                    delivery.setOrder(order);
                    DeliveryService.SaveDelivery(delivery);
                }
            }

            return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
