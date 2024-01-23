package sb.OnlineFoodDeliverySystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sb.OnlineFoodDeliverySystem.model.*;
import sb.OnlineFoodDeliverySystem.service.impl.OrderServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.RestaurantServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.UserInfoServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineFoodDeliverySystemApplication implements CommandLineRunner {

    @Autowired
    private UserInfoServiceImpl userInfoService;


    @Autowired
    private RestaurantServiceImpl restaurantService;


    @Autowired
    private OrderServiceImpl orderService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineFoodDeliverySystemApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        //  saveUserInfoWithAccountWithoutOrders(); // -> 1 User with 1 Account
        // saveRestaurantWithMenus(); // -> One Restaurant has Multiple Menus

    }

    public void saveUserInfoWithAccountWithoutOrders() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sonu");
        userInfo.setPassword("sonu");
        userInfo.setRole("ROLE_ADMIN");

        List<Account> accounts = new ArrayList<>();

        Account account = new Account();
        account.setAccountNumber("50123");
        account.setBalance(10000d);
        account.setUserInfo(userInfo);

        accounts.add(account);

        userInfo.setAccounts(accounts);
        userInfoService.saveUserInfo(userInfo);

    }


    public void saveRestaurantWithMenus() {

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Kodi Kura Chitti Gaare");
        restaurant1.setLocation("2nd Floor Plot, 722, Rd Number 36, above Bajaj Electronics, opp. Metro pillar # C1705, CBI Colony, Jubilee Hills, Hyderabad, Telangana 500033");
        restaurant1.setRating(5);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Babai Hotel");
        restaurant2.setLocation("Rd Number 1, Kukatpally Housing Board Colony, Kukatpally, Hyderabad, Telangana 500072");
        restaurant2.setRating(4);

        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem menuItem1 = new MenuItem();
        menuItem1.setName("Chicken Biryani");
        menuItem1.setPrice(new BigDecimal(250));

        menuItem1.setRestaurant(restaurant1);

        MenuItem menuItem2 = new MenuItem();
        menuItem2.setName("Chicken65");
        menuItem2.setPrice(new BigDecimal(99));

        menuItem2.setRestaurant(restaurant1);


        //////////////////////////////////////////


        List<MenuItem> anotherMenuItems = new ArrayList<>();

        MenuItem menuItem3 = new MenuItem();
        menuItem3.setName("Dosa");
        menuItem3.setPrice(new BigDecimal(50));

        menuItem3.setRestaurant(restaurant2);

        MenuItem menuItem4 = new MenuItem();
        menuItem4.setName("Vada");
        menuItem4.setPrice(new BigDecimal(40));

        menuItem4.setRestaurant(restaurant2);

/////////////////////////////////////////////////////////

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);


        anotherMenuItems.add(menuItem3);
        anotherMenuItems.add(menuItem4);

        restaurant1.setMenuItems(menuItems);
        restaurant2.setMenuItems(anotherMenuItems);

        restaurantService.saveRestaurant(restaurant1);
        restaurantService.saveRestaurant(restaurant2);

    }

    public void saveOrderWithDelivery() {


    }


}
