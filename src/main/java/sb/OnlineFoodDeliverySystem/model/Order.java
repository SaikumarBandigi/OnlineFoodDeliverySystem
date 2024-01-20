package sb.OnlineFoodDeliverySystem.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalAmount;
    private LocalDateTime orderDate;

    // Getters and Setters

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Delivery> deliveries=new ArrayList<>();



}
