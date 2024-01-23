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

        UserInfo userInfo = userInfoService.getUserById(userId);
        order.setUser(userInfo);

        Order newOrder = orderService.saveOrder(order);

        if (newOrder != null) {
            Account account = accountService.getAccountByUserInfo(userInfo);
            Double DbBalance = account.getBalance();
            System.out.println(DbBalance);
            if (DbBalance > newOrder.getTotalAmount().doubleValue()) {
                Double presentbalance = DbBalance - newOrder.getTotalAmount().doubleValue();
                System.out.println(presentbalance);
                accountService.updateAccountBalance(presentbalance, account);

                Delivery delivery = new Delivery();
                delivery.setDeliveryDate(null);
                delivery.setStatus("Not Delivered");
                delivery.setOrder(order);
                DeliveryService.SaveDelivery(delivery);
            }
        }

        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }


}
