package com.linebot.connector.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by han on 2016. 4. 12..
 */
@Data
@AllArgsConstructor
public class ChannelInfo {

    String channelId;
    String channelSecret;
    String channelOwnerMID;
}
