package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.UserInfo;

import java.util.List;

public interface UserInfoService {


    UserInfo saveUserInfo(UserInfo userInfo);


    UserInfo getUserById(Long userId);

    List<UserInfo> getAllUsers();

    UserInfo getUserInfo(UserInfo userInfo);
}
