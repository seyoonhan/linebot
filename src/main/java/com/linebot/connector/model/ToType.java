package com.linebot.connector.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by han on 2016. 4. 12..
 */
public enum ToType {
    USER(1);

    int code;

    ToType(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return this.code;
    }
}
