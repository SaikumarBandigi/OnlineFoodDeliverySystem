//package sb.OnlineFoodDeliverySystem.config;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Component
//public class FoodWebAppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
//
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName()+ "\"");
//        response.sendError(response.SC_UNAUTHORIZED, authException.getMessage());
//    }
//
//
//    public void afterPropertiesSet() {
//        setRealmName("Food WebApp Realm Name");
//    }
//
//
//}
