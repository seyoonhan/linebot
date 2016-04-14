package com.linebot.connector.model;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

/**
 * Created by han on 2016. 4. 12..
 */
@Data
@Builder
public class Content {
    //message id
    String id;
    ContentType contentType;
    //sender mid
    String from;
    DateTime createdTime;
    List<String> to;
    ToType toType = ToType.USER;
    Map<String, Object> contentMetaData;
    String text;
    Location location;
    String originalContentUrl;
    String previewImageUrl;

    //operation
    List<String> params;

    public void setStickerMessageContentMetaData(String STKPKGID, String STKID, String STKVER, String STKTXT){
        contentMetaData = Maps.newHashMap();
        contentMetaData.put("STKPKGID", STKPKGID);
        contentMetaData.put("STKID", STKID);
        contentMetaData.put("STKVER", STKVER);
        contentMetaData.put("STKTXT", STKTXT);
    }

    public void setContactMessageMetaData(String mid, String displayName){
        contentMetaData = Maps.newHashMap();
        contentMetaData.put("mid", mid);
        contentMetaData.put("displayName", displayName);
    }

    public void setAudioContentMetaData(Long audioLength){
        contentMetaData = Maps.newHashMap();
        contentMetaData.put("AUDLEN", String.valueOf(audioLength));
    }
}
