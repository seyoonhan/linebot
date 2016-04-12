package com.linebot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.linebot.connector.client.DefaultLineBot;
import com.linebot.connector.model.ChannelInfo;
import com.linebot.connector.model.Content;
import com.linebot.connector.model.ContentType;
import com.linebot.connector.model.SendMessage;
import com.linebot.connector.repository.ChannelInfoRepository;

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
    public String send() {
        String mid = "";
        ChannelInfo channelInfoByMid = channelInfoRepository.getChannelInfoByMid(null);
        Content content = Content.builder().contentType(ContentType.TEXT).text("test message").build();
        defaultLineBot.sendMessage(
            channelInfoByMid,
            (SendMessage)SendMessage.builder().from(channelInfoByMid.getChannelOwnerMID()).fromChannel(
                channelInfoByMid.getChannelId()).to(Lists.newArrayList("u75442c2e79c308af23e1c0f4c9687109")).content(
                content).build());
    }
}
