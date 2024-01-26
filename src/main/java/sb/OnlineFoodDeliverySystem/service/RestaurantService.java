package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {


    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);

    Restaurant getRestaurantByName(String restaurantName);

    Restaurant saveNewRestaurant(Restaurant restaurant);
}
