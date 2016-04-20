package com.linebot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.linebot.user.model.User;
import com.linebot.user.model.UserDetails;

/**
 * Created by han on 2016. 4. 20..
 */
@Component
public class SecurityUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserById(s);
        if (user == null) {
            throw new UsernameNotFoundException("not found user : {" + s + "}");
        } else{
            return new UserDetails(user);
        }
    }
}
