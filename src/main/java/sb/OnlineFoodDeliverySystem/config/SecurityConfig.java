//package sb.OnlineFoodDeliverySystem.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import sb.OnlineFoodDeliverySystem.service.impl.UserDetailsServiceImpl;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private FoodWebAppAuthenticationEntryPoint foodWebAppAuthenticationEntryPoint;
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/user/saveUser").permitAll() // Allow unauthenticated access to this URL
//                .antMatchers("/api/user/getAllUsers").hasRole("ADMIN") // Allow only admin for getAllAccounts
//                .anyRequest().authenticated()
//                .and().httpBasic().realmName("Food WebApp Realm Name").authenticationEntryPoint(foodWebAppAuthenticationEntryPoint);
//    }
//
//
//    /*
//
//    anyRequest() means any request is authenticated because in real time scenario to browse or to order something
//    user gets logged in so i have authenticated here
//
//     */
//
//    /*
//
//    if we want to access the url GET-> localhost:8080/api/user/getAllUsers
//
//Authorization
//Basic Auth
//Username:Sonu
//Password:Sonu
//
//then hit the url
//
//     */
//
//
//
//}
//
