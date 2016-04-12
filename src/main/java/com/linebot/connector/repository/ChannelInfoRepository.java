package com.linebot.connector.repository;

import com.linebot.connector.model.ChannelInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Created by han on 2016. 4. 12..
 */
@Repository
public class ChannelInfoRepository {

    public ChannelInfo getChannelInfo(String channelId){
        return null;
    }

    public ChannelInfo getChannelInfoByMid(String mid){

        if(StringUtils.isEmpty(mid)){
            return new ChannelInfo("1463751543", "4773e1315bd085eb56d77f6d8003cc44", "u8b86fe2b0f3eca4fe5e56292a34ba914");
        }

        return null;
    }


}
