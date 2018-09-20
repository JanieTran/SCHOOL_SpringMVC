package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by CoT on 11/12/17.
 */

@Configuration
@EnableWebSecurity
// Allow security in each method
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("henry").password("123456")
//                .roles("USER");
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("123456")
//                .roles("ADMIN", "USER", "ADD_STUDENT", "DELETE_STUDENT", "GET_STUDENT");
//        auth.inMemoryAuthentication()
//                .withUser("boss").password("boss")
//                .roles("BOSS");
//
//        auth.inMemoryAuthentication()
//                .withUser("add").password("123")
//                .roles("USER", "ADD_STUDENT");
//        auth.inMemoryAuthentication()
//                .withUser("delete").password("123")
//                .roles("USER", "DELETE_STUDENT");
//        auth.inMemoryAuthentication()
//                .withUser("get").password("123")
//                .roles("USER", "GET_STUDENT");

        auth.userDetailsService(userDetailsService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // /public/ doesn't need authentication
                .antMatchers("/public/**").permitAll()

                // any URL containing /admin/
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_BOSS')")

                // any URL containing /students/
                .antMatchers("/students/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_GET_STUDENT')")

                // all other requests must redirect to login if not logged in
                .anyRequest().authenticated()

                // HTML login form
//                .and().formLogin()
                // HTTP basic authentication - pop up message on browser
                .and().httpBasic()

                // Cross-Site Request Forgery
                .and().csrf().disable();
    }
}
