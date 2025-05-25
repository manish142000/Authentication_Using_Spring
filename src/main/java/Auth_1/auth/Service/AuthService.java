package Auth_1.auth.Service;


import Auth_1.auth.DTO.UserDto;
import Auth_1.auth.Model.User;
import Auth_1.auth.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepo;
    @Autowired
    private PasswordEncoder _passwordEncoder;
    public void registerUser(UserDto user) {
        User newUser = new User();
        newUser.setUserName(user.username);
        newUser.setPassword(_passwordEncoder.encode(user.password));
        authRepo.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), Collections.emptyList());
    }
}
