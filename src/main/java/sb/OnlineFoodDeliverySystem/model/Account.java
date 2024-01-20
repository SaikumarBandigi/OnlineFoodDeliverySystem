package sb.OnlineFoodDeliverySystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;

    private double balance;

    @ManyToOne(targetEntity = UserInfo.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private UserInfo userInfo;

}
