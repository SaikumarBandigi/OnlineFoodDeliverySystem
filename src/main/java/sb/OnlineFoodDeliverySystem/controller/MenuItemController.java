package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.MenuItemService;
import sb.OnlineFoodDeliverySystem.service.RestaurantService;

@RestController
@RequestMapping("/api/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/saveMenuItem")
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {

        Restaurant restaurant = menuItem.getRestaurant();
        menuItem.setRestaurant(restaurant);

        return menuItemService.saveMenuItem(menuItem);

    }


}
