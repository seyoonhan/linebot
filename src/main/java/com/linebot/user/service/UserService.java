package com.linebot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linebot.repository.ChannelInfoRepository;
import com.linebot.repository.UserInfoRepository;
import com.linebot.user.model.User;

/**
 * Created by han on 2016. 4. 15..
 */
@Service
public class UserService {

    @Autowired
    ChannelInfoRepository channelInfoRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    public User save(User user){
        return (User) userInfoRepository.save(user);
    }

}
