package sb.OnlineFoodDeliverySystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private LocalDateTime deliveryDate;

    // Getters and Setters

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Order.class)
    @JoinColumn(name = "fk_order_id")
    private Order order;



}
