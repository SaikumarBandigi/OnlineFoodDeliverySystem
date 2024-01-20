package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.MenuItem;

public interface MenuItemDao extends JpaRepository<MenuItem, Long> {

}