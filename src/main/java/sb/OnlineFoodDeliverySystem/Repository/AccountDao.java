package sb.OnlineFoodDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.OnlineFoodDeliverySystem.model.Account;

public interface AccountDao extends JpaRepository<Account,Long> {
    Account findByAccountNumber(String accountNumber);

}
