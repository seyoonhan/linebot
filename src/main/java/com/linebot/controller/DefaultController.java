package com.linebot.controller;

import com.google.common.collect.Lists;
import com.linebot.connector.client.DefaultLineBot;
import com.linebot.connector.model.*;
import com.linebot.connector.repository.ChannelInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by han on 2016. 4. 12..
 */
@RestController
public class DefaultController {

    @Autowired
    DefaultLineBot defaultLineBot;

    @Autowired
    ChannelInfoRepository channelInfoRepository;

    @RequestMapping("/send/message")
    public HashMap send() {
        ChannelInfo channelInfoByMid = channelInfoRepository.getChannelInfoByMid(null);
        Content content = Content.builder().contentType(ContentType.TEXT).text("test message").toType(ToType.USER).build();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setFrom(channelInfoByMid.getChannelOwnerMID());
        sendMessage.setFromChannel(channelInfoByMid.getChannelId());
        sendMessage.setTo(Lists.newArrayList("u75442c2e79c308af23e1c0f4c9687109"));
        sendMessage.setContent(content);

        return defaultLineBot.sendMessage(channelInfoByMid, sendMessage);

    }
}
