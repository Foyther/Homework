package utils;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.AuthorityRepository;
import repositories.UserRepository;

/**
 * Created by Nurislam on 30.05.2017.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityJPARepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login);
        return user;
    }
    public void registerUser(User user) {
        if(userRepository.findUserByLogin(user.getEmail()) != null){
            throw new DuplicateKeyException("Duplicate key - email field.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addAuthority(authorityJPARepository.findByAuthority("ROLE_USER"));
        userRepository.save(user);
    }

    public UserDetails loadUserByID(int id) {
        User user = userRepository.findOne(id);
        return user;
    }

}

