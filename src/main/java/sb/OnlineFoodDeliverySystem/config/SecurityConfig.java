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
//                .antMatchers("/api/account/saveAccount").permitAll() // Allow unauthenticated access to this URL
//                .antMatchers("/api/account/getAllAccounts").hasRole("ADMIN") // Allow only admin for getAllAccounts
//                .anyRequest().authenticated()
//                .and().httpBasic();
//    }
//
//
//
//}
//
