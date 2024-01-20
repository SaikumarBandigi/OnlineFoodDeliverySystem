package sb.OnlineFoodDeliverySystem.model;

import javax.persistence.*;
import java.math.BigDecimal;
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
@Table(name = "users")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private BigDecimal balance;

    // Getters and Setters

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders=new ArrayList<>();



}
