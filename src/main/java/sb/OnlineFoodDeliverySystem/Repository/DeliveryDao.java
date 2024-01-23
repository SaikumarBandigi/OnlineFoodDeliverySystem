package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Delivery;
import sb.OnlineFoodDeliverySystem.model.Order;

public interface DeliveryDao extends JpaRepository<Delivery, Long> {
    Delivery findByOrder(Order order);

}