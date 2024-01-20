// src/main/java/sb/OnlineFoodDeliverySystem/controller/UserController.java
package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.Repository.UserInfoDao;
import sb.OnlineFoodDeliverySystem.exception.UsernameIsCorrectPasswordException;
import sb.OnlineFoodDeliverySystem.exception.UsernameNotFoundException;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.OrderService;
import sb.OnlineFoodDeliverySystem.service.UserInfoService;

import java.util.List;
import java.util.NoSuchElementException;


//@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private OrderService orderService;


    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody UserInfo userInfo) {
        try {
            UserInfo existingUser = userInfoService.getUserInfo(userInfo);
            System.out.println("came...");
            return ResponseEntity.ok("Login successful!");
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username is Wrong.Please enter Right Username");
        } catch (UsernameIsCorrectPasswordException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username is Correct but Password is wrong");
        } catch (Exception ex) {
            // Log the exception for debugging purposes
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }
    }


    @GetMapping("/api/getOrders/{username}/{password}")
    public List<Order> getOrders(@PathVariable String username, @PathVariable String password) {


        try {
            UserInfo getActiveUserInfo = userInfoDao.getActiveUser(username);
            if (getActiveUserInfo != null && password.equals(getActiveUserInfo.getPassword())) {
                return orderService.orderList();
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }

    }


}
