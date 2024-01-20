package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {
}