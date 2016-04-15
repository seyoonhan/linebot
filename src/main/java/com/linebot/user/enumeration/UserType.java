package com.linebot.user.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by han on 2016. 4. 15..
 */
public enum UserType {

    NORMAL(1),
    GUEST(9);

    int code;

    UserType(int code){
        this.code = code;
    }

    @JsonValue
    public int getCode(){
        return this.code;
    }

}
