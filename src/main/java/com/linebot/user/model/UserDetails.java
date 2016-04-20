package com.linebot.user.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by han on 2016. 4. 20..
 */
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private Set<GrantedAuthority> authorities = new HashSet<>();
    private User user;

    public UserDetails(User user, String credentials) {
        this.authorities.add(new SimpleGrantedAuthority(credentials));
        this.user = user;
    }

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        if (user == null) {
            return null;
        }

        return user.getPw();
    }

    @Override
    public String getUsername() {
        if (user == null || user.getId() == null) {
            return "";
        }

        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
