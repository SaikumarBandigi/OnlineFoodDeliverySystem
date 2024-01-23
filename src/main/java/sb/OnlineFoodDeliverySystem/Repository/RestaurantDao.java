package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sb.OnlineFoodDeliverySystem.model.Restaurant;

import java.util.Optional;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByIdOrName(Long id, String name);


    // using Derived Method
   // Restaurant findByName(String name);


    // using JPQL
    @Query("SELECT r FROM Restaurant r WHERE r.name = :Name")
    Restaurant findByName(@Param("Name") String Name);

}