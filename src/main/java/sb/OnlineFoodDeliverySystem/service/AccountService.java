package sb.OnlineFoodDeliverySystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.AccountDao;
import sb.OnlineFoodDeliverySystem.exception.InsufficientBalanceException;
import sb.OnlineFoodDeliverySystem.model.Account;

import java.util.NoSuchElementException;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account saveAccount(Account account) {
        return accountDao.save(account);
    }

    public Account getAccount(String accountNumber) {
        return accountDao.findByAccountNumber(accountNumber);
    }


    public void payAmount(String accountNumber, double amount) throws InsufficientBalanceException {

        Account account = accountDao.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new NoSuchElementException("Account not found");
        }

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }



    }


}
