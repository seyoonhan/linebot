package com.linebot.user.model;

import org.joda.time.DateTime;

import com.linebot.user.enumeration.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by han on 2016. 4. 15..
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String pw;

    private String mid;
    private String name;
    private String office;
    private String mobile;
    private String address1;
    private String address2;
    private String address3;

    private UserType userType;

    private DateTime registered;
    private DateTime lastLogin;
    private DateTime modified;
}
