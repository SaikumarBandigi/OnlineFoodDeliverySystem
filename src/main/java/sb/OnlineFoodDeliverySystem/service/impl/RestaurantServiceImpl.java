package sb.OnlineFoodDeliverySystem.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.RestaurantDao;
import sb.OnlineFoodDeliverySystem.model.Restaurant;
import sb.OnlineFoodDeliverySystem.service.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    private RestaurantDao restaurantDao;


    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantDao.findById(id).get();
    }


}
