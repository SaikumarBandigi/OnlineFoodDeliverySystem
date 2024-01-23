package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.UserInfo;

public interface UserInfoService {


    UserInfo saveUserInfo(UserInfo userInfo);


    UserInfo getUserById(Long userId);
}
