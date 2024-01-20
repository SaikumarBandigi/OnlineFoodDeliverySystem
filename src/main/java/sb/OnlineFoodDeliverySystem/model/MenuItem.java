package sb.OnlineFoodDeliverySystem.model;


import javax.persistence.*;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;

    // Getters and Setters

    @ManyToOne(targetEntity = Restaurant.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_restaurant_id")
    private Restaurant restaurant;


}
