package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.exception.ResourceNotFoundException;
import sb.OnlineFoodDeliverySystem.exception.RestaurantNotFoundException;
import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.MenuItemService;
import sb.OnlineFoodDeliverySystem.service.impl.MenuItemServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.RestaurantServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemServiceImpl menuItemService;


    @Autowired
    private RestaurantServiceImpl restaurantService;

    @GetMapping("/getAllMenusInARestaurant/{id}")
    public ResponseEntity<List<MenuItem>> getAllMenusInARestaurant(@PathVariable Long id) {
        try {
            Restaurant restaurant = restaurantService.getRestaurantById(id);
            List<MenuItem> menuItemList = menuItemService.getAllMenuItemsByRestaurant(restaurant);
            return new ResponseEntity<>(menuItemList, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            throw new RestaurantNotFoundException("Restaurant Not Found for given ID: " + id);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Global exception handler
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
