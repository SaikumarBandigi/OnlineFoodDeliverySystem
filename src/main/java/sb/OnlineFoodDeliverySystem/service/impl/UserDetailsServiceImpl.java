//package sb.OnlineFoodDeliverySystem.service.impl;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import sb.OnlineFoodDeliverySystem.Repository.UserInfoDao;
//import sb.OnlineFoodDeliverySystem.model.UserInfo;
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserInfoDao userInfoDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        UserInfo userInfo = userInfoDao.getActiveUser(userName);
//        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
//
//        User user = new User(userInfo.getUsername(), userInfo.getPassword(),Arrays.asList(authority));
//
//        UserDetails userDetails = (UserDetails)user;
//        return userDetails;
//    }
//
//
//}
