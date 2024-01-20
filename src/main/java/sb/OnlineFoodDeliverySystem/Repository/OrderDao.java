package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}