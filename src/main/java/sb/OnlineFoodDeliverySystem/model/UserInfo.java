package sb.OnlineFoodDeliverySystem.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // Getters and Setters


    @OneToMany(mappedBy = "user", targetEntity = Order.class)
    @JsonIgnore  // Exclude this property from serialization
    private List<Order> orders = new ArrayList<>();


    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, targetEntity = Account.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();


}
