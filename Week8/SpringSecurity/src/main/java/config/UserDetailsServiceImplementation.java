package config;

import model.UserRoles;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // Will use Hibernate session to query user/pw/roles later

//        if (!s.equalsIgnoreCase("get"))
//            throw new UsernameNotFoundException("");
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        GrantedAuthority authority = new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "ROLE_GET_STUDENT";
//            }
//        };
//
//        authorities.add(authority);
//
//        User user = new User("get", "123", authorities);
//
//        return user;

        Users user = userService.getUserByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (final UserRoles userRole: user.getUserRoles()) {
            authorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return userRole.getRole().getName();
                }
            });
        }

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
