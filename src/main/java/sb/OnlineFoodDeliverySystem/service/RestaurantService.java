package sb.OnlineFoodDeliverySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.RestaurantDao;
import sb.OnlineFoodDeliverySystem.model.Restaurant;

import java.util.List;


@Service
public class RestaurantService {


    @Autowired
    private RestaurantDao restaurantDao;


    public List<Restaurant> getAll() {
        return restaurantDao.findAll();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }


    public List<Restaurant> saveAllRestaurants(List<Restaurant> restaurantList) {
        return restaurantDao.saveAll(restaurantList);
    }

    public Restaurant getRestaurantByIdOrName(Long id, String name) {
        return restaurantDao.findByIdOrName(id, name).get();
    }


}
