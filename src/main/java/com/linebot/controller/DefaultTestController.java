package com.linebot.controller;

import com.google.common.collect.Lists;
import com.linebot.connector.client.DefaultLineBot;
import com.linebot.connector.model.*;
import com.linebot.repository.ChannelInfoRepository;
import com.linebot.user.UserHelper;
import com.linebot.user.enumeration.UserType;
import com.linebot.user.model.User;
import com.linebot.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by han on 2016. 4. 12..
 */
@RestController
@Slf4j
public class DefaultTestController {

    @Autowired
    DefaultLineBot defaultLineBot;

    @Autowired
    ChannelInfoRepository channelInfoRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/send/message")
    public HashMap send() {

        User currentUser = UserHelper.getCurrentUser();
        log.debug(currentUser.getId());

        ChannelInfo channelInfoByMid = channelInfoRepository.findByChannelOwnerMID("u8b86fe2b0f3eca4fe5e56292a34ba914");
        if(channelInfoByMid == null){
            channelInfoByMid = new ChannelInfo("u8b86fe2b0f3eca4fe5e56292a34ba914", "1463751543", "4773e1315bd085eb56d77f6d8003cc44");
        }

        Content content = Content.builder().contentType(ContentType.TEXT).text("test message").toType(ToType.USER).build();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setFrom(channelInfoByMid.getChannelOwnerMID());
        sendMessage.setFromChannel(channelInfoByMid.getChannelId());
        sendMessage.setTo(Lists.newArrayList("u75442c2e79c308af23e1c0f4c9687109"));
        sendMessage.setContent(content);

        return defaultLineBot.sendMessage(channelInfoByMid, sendMessage);

    }

    @RequestMapping("/newuser")
    public User makeUser() {
        User user = User.builder().userType(UserType.NORMAL).id("test").pw("test").mid("u8b86fe2b0f3eca4fe5e56292a34ba914").registered(DateTime.now()).build();
        ChannelInfo channelInfo = new ChannelInfo("u8b86fe2b0f3eca4fe5e56292a34ba914", "1463751543", "4773e1315bd085eb56d77f6d8003cc44");
        Object insert = channelInfoRepository.insert(channelInfo);
        return userService.save(user);
    }


}
