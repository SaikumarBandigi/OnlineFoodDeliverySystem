package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.AccountDao;
import sb.OnlineFoodDeliverySystem.model.Account;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getAccount(Long id) {
        return accountDao.findById(id).get();
    }


    @Override
    public Account getAccountByUserInfo(UserInfo userInfo) {
        return accountDao.findByUserInfo(userInfo);
    }

    @Override
    public Account updateAccountBalance(Double Balance, Account account) {

        Account DBACcount = getAccount(account.getId());
        if (account.getBalance() != null) {
            DBACcount.setBalance(Balance);
            accountDao.save(DBACcount);

        }
        return DBACcount;
    }



}
