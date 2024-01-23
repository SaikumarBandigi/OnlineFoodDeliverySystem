package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.model.UserInfo;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account,Long> {

    Account findByAccountNumber(String accountNumber);

    Optional<Account> findByUserInfo(UserInfo userInfo);

}
