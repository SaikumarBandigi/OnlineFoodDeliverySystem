// src/main/java/sb/OnlineFoodDeliverySystem/controller/UserController.java
package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sb.OnlineFoodDeliverySystem.exception.UsernameIsCorrectPasswordException;
import sb.OnlineFoodDeliverySystem.exception.UsernameNotFoundException;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.impl.UserInfoServiceImpl;

import java.util.List;


//@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

//    @Autowired
//    private UserInfoDao userInfoDao;

//    @Autowired
//    private OrderService orderService;


//    @GetMapping("/getUser/{id}")
//    public UserInfo getUserInfo(@PathVariable Long id) {
//        return userInfoService.getUserById(id);
//    }


    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserInfo userInfo, UriComponentsBuilder builder) {

        UserInfo userInfo1 = userInfoService.saveUserInfo(userInfo);

        if (userInfo1.getId() == 0) {
            return new ResponseEntity<>("This Topic already exist", HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/getUser/{id}").buildAndExpand(userInfo.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserInfo>> getAllUsers() {

        List<UserInfo> userInfoList = userInfoService.getAllUsers();
        return new ResponseEntity<>(userInfoList, HttpStatus.OK);

    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInfo userInfo) {
        try {
            if (userInfo != null && userInfo.getUsername() != null && userInfo.getPassword() != null) {
                UserInfo existingUser = userInfoService.getUserInfo(userInfo);

                if (existingUser != null && existingUser.getPassword().equals(userInfo.getPassword())) {
                    return ResponseEntity.ok("Login successful!");
                } else if (existingUser != null) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request body");
            }

        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found. Please enter the correct username");
        } catch (Exception ex) {
            // Log the exception for debugging purposes
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }
    }



//    @GetMapping("/api/getOrders/{username}/{password}")
//    public List<Order> getOrders(@PathVariable String username, @PathVariable String password) {
//
//
//        try {
//            UserInfo getActiveUserInfo = userInfoDao.getActiveUser(username);
//            if (getActiveUserInfo != null && password.equals(getActiveUserInfo.getPassword())) {
//                return orderService.orderList();
//            } else {
//                throw new NoSuchElementException();
//            }
//        } catch (NoSuchElementException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


}
