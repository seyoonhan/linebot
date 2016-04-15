package com.linebot.repository;

import com.linebot.connector.model.ChannelInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by han on 2016. 4. 12..
 */
public interface ChannelInfoRepository<T extends ChannelInfo> extends MongoRepository<T, String>{
    ChannelInfo findByChannelId(String channelId);
    ChannelInfo findByChannelOwnerMID(String ownerMid);

}
