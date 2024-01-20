package sb.OnlineFoodDeliverySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.UserInfoDao;
import sb.OnlineFoodDeliverySystem.exception.UserNotFoundException;
import sb.OnlineFoodDeliverySystem.exception.UsernameIsCorrectPasswordException;
import sb.OnlineFoodDeliverySystem.exception.UsernameNotFoundException;
import sb.OnlineFoodDeliverySystem.model.UserInfo;

import java.util.NoSuchElementException;
import java.util.Objects;


@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo getUserInfo(UserInfo userInfo) {

        UserInfo existingUser = userInfoDao.getActiveUser(userInfo.getUsername());

        if (existingUser == null) {
            throw new UsernameNotFoundException("Username is Wrong.Please Check");
        }

        if (existingUser != null && existingUser.getPassword().equals(userInfo.getPassword())) {
            return existingUser;
        } else {
            throw new UsernameIsCorrectPasswordException("Username is Correct but Password is wrong");
        }
    }


    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

}
