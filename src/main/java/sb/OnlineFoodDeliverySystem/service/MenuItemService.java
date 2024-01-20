package sb.OnlineFoodDeliverySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.MenuItemDao;
import sb.OnlineFoodDeliverySystem.model.MenuItem;


@Service
public class MenuItemService {


    @Autowired
    private MenuItemDao menuItemDao;

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemDao.save(menuItem);
    }



}
