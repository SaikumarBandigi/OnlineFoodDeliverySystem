package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.MenuItemService;
import sb.OnlineFoodDeliverySystem.service.impl.MenuItemServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.RestaurantServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemServiceImpl menuItemService;


    @Autowired
    private RestaurantServiceImpl restaurantService;

    @GetMapping("/getAllMenusInARestaurant/{id}")
    public List<MenuItem> getAllMenusInARestaurant(@PathVariable Long id) {

        Restaurant restaurant = restaurantService.getRestaurantById(id);
        List<MenuItem> menuItemList = menuItemService.getAllMenuItemsByRestaurant(restaurant);
        return menuItemList;

    }


}
