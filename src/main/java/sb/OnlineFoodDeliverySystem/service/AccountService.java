package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.model.UserInfo;

public interface AccountService {

    Account getAccount(Long id);

    Account getAccountByUserInfo(UserInfo userInfo);

    Account updateAccountBalance(Double balance, Account account);

}
