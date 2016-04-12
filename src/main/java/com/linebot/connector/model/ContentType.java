package com.linebot.connector.model;

/**
 * Created by han on 2016. 4. 12..
 */
public enum ContentType {

    TEXT(1), IMAGE(2), VIDEO(3), AUDIO(4), LOCATION(7), STICKER(8), CONTACT(10);

    int code;

    ContentType(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

}
