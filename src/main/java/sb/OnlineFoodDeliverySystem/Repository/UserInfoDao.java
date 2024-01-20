package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sb.OnlineFoodDeliverySystem.model.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

    @Query(value = "SELECT u FROM UserInfo u WHERE username=?1")
    UserInfo getActiveUser(String userName);



}