package sb.OnlineFoodDeliverySystem.model;

import javax.persistence.*;
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
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int rating;

    // Getters and Setters

    @OneToMany(mappedBy = "restaurant", targetEntity = MenuItem.class)
    @JsonIgnore
    private List<MenuItem> menuItems = new ArrayList<>();

}
