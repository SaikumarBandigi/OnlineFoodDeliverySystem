package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.MenuItemDao;
import sb.OnlineFoodDeliverySystem.exception.MenuItemNotFoundException;
import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.MenuItemService;

import java.util.List;


@Service
public class MenuItemServiceImpl implements MenuItemService {


    @Autowired
    private MenuItemDao menuItemDao;

    @Override
    public List<MenuItem> getAllMenuItemsByRestaurant(Restaurant restaurant) {

        List<MenuItem> menuItemList;
        menuItemList = menuItemDao.findByRestaurant(restaurant);

        if (menuItemList.isEmpty() || menuItemList == null) {
            throw new MenuItemNotFoundException("MenuItems are not defined in this Restaurant: " + restaurant.getName() + "Restaurant ID: " + restaurant.getId());

        } else {
            return menuItemList;
        }

    }


}
