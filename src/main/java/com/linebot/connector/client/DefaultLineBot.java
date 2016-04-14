package com.linebot.connector.client;

import com.google.common.collect.Maps;
import com.linebot.connector.model.ChannelInfo;
import com.linebot.connector.model.SendMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by han on 2016. 4. 12..
 */
@Component
public class DefaultLineBot implements InitializingBean, ApiPath{

    String baseUrl = "https://trialbot-api.line.me/v1/";
    RestTemplate restTemplate;

    public HashMap sendMessage(ChannelInfo channelInfo, SendMessage sendMessage){
        MultiValueMap<String, String> defaultHeaderValue = getDefaultHeaderValue(channelInfo);
        HttpEntity<SendMessage> request = new HttpEntity<>(sendMessage, defaultHeaderValue);
        return restTemplate.postForObject(baseUrl + ApiPath.SEND_MSG, request, HashMap.class, Maps.newHashMap());
    }

    private MultiValueMap<String, String> getDefaultHeaderValue(ChannelInfo channelInfo) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("X-Line-ChannelID", channelInfo.getChannelId());
        headers.add("X-Line-ChannelSecret", channelInfo.getChannelSecret());
        headers.add("X-Line-Trusted-User-With-ACL", channelInfo.getChannelOwnerMID());
        headers.add("Content-Type", "application/json; charser=UTF-8");
        return headers;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
}
