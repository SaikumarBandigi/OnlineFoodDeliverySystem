package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.RestaurantDao;
import sb.OnlineFoodDeliverySystem.exception.RestaurantNotFoundException;
import sb.OnlineFoodDeliverySystem.model.MenuItem;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.RestaurantService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        try {
            List<MenuItem> menuItemList = restaurant.getMenuItems();
            System.out.println("sai kumar");
            restaurant.setMenuItems(menuItemList);
            return restaurantDao.save(restaurant);
        } catch (Exception e) {
            // Handle specific exceptions or log the error
            throw new RuntimeException("Error saving restaurant: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        try {
            return restaurantDao.findAll();
        } catch (Exception e) {
            // Handle specific exceptions or log the error
            throw new RuntimeException("Error retrieving all restaurants: " + e.getMessage(), e);
        }
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        try {
            Optional<Restaurant> optionalRestaurant = restaurantDao.findById(id);
            return optionalRestaurant.get();
        } catch (NoSuchElementException e) {
            // Log the database-specific exception for troubleshooting
            //    logger.error("Error accessing database while retrieving restaurant by id: {}. {}", id, e.getMessage(), e);
            throw new NoSuchElementException("Internal Server Error");
        } catch (Exception e) {
            // Log the generic exception for troubleshooting
            // logger.error("Error retrieving restaurant by id: {}. {}", id, e.getMessage(), e);
            throw new RuntimeException("Internal Server Error");
        }
    }

    @Override
    public Restaurant getRestaurantByName(String restaurantName) {
        return restaurantDao.findByName(restaurantName);
    }


}
