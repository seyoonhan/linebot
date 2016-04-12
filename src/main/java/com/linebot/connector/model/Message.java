package com.linebot.connector.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by han on 2016. 4. 12..
 */
@Data
@Builder
public class Message {

    String from;
    String fromChannel;
    List<String> to;
    Long toChannel = 1383378250L;
    String eventType;
    String id;
    Content content;
}
