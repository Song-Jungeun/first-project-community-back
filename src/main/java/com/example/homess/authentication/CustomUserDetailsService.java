package com.example.homess.authentication;

import com.example.homess.mappers.UserMapper;
import com.example.homess.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    UserMapper userMapper;

    @Autowired
    public CustomUserDetailsService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.findUser(username);
        if (user.isPresent()) {
            User user1 = user.get();
            return new CustomUserDetails(user1);
        }
        throw new UsernameNotFoundException("Error");

    }
}
