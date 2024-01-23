package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.MenuItemDao;
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
        return menuItemDao.findByRestaurant(restaurant);
    }


}
