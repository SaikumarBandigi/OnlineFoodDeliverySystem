package sb.OnlineFoodDeliverySystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.RestaurantService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/BrowseRestaurants")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping("/getParticularRestaurant")
    public ResponseEntity<Restaurant> getAllRestaurants(@RequestParam(name = "id", required = false) Long id, @RequestParam(name = "name", required = false) String name) {

        Restaurant restaurant = null;
        try {
            restaurant = restaurantService.getRestaurantByIdOrName(id, name);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @PostMapping("/saveRestaurant")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        try {
            Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
            return ResponseEntity.ok(savedRestaurant);
        } catch (Exception e) {
            // Handle the exception and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping("/saveAllRestaurants")
    public List<Restaurant> saveAllRestaurants(@RequestBody List<Restaurant> restaurantList) {
        return restaurantService.saveAllRestaurants(restaurantList);
    }


}
