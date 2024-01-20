package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Restaurant;

import java.util.Optional;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByIdOrName(Long id, String name);


}