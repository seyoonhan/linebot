package com.linebot.connector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by han on 2016. 4. 12..
 */
@Data
@AllArgsConstructor
public class ChannelInfo implements Serializable{
    String channelOwnerMID;
    @Id
    String channelId;
    String channelSecret;

}
