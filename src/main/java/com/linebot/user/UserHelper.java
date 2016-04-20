package com.linebot.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.linebot.user.model.User;
import com.linebot.user.model.UserDetails;

/**
 * Created by han on 2016. 4. 20..
 */
public class UserHelper {
    public static User getCurrentUser() {
        User user = null;
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) {
            Authentication authentication = context.getAuthentication();

            if (authentication != null) {
                Object principal = authentication.getPrincipal();

                if (principal != null && principal instanceof UserDetails) {
                    user = ((UserDetails)principal).getUser();
                }
            }
        }

        return user;
    }
}
