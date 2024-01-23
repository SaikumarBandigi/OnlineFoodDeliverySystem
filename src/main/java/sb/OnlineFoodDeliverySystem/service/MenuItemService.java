package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Restaurant;

import java.util.List;

public interface MenuItemService {

    List<MenuItem> getAllMenuItemsByRestaurant(Restaurant restaurant);

}
