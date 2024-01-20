package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Delivery;

public interface DeliveryDao extends JpaRepository<Delivery, Long> {
}