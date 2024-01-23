package sb.OnlineFoodDeliverySystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.impl.RestaurantServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @GetMapping("/BrowseRestaurants")
    public ResponseEntity<List<Restaurant>> browseRestaurants() {
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Or you can return a custom error message
        } catch (Exception e) {
            // Handle other exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Or you can return a custom error message
        }
    }



}
