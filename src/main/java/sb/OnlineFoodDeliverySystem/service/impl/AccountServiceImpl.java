package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.AccountDao;
import sb.OnlineFoodDeliverySystem.exception.AccountNotFoundException;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getAccount(Long id) {
        return accountDao.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
    }

    @Override
    public Account getAccountByUserInfo(UserInfo userInfo) {
        return accountDao.findByUserInfo(userInfo).orElseThrow(() -> new AccountNotFoundException("Account not found for user: " + userInfo.getId()));
    }

    @Override
    public Account updateAccountBalance(Double balance, Account account) {
        try {
            Account dbAccount = getAccount(account.getId());

            if (account.getBalance() != null) {
                dbAccount.setBalance(balance);
                accountDao.save(dbAccount);
            }

            return dbAccount;
        } catch (AccountNotFoundException e) {
            // Log the exception or handle it as needed
            throw e;
        } catch (Exception e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("Error updating account balance", e);
        }
    }
}
