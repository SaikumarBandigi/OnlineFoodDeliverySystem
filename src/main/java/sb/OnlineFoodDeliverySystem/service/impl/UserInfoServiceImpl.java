package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.UserInfoDao;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }


    @Override
    public UserInfo getUserById(Long userId) {
        return userInfoDao.findById(userId).get();
    }


}
