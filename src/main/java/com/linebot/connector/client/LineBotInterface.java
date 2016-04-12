package com.linebot.connector.client;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by han on 2016. 4. 12..
 */
public interface LineBotInterface {

    @POST("/v1/events")
    @Headers({
            "Content-Type: application/json; charser=UTF-8",
            "X-Line-ChannelID",

    })
    Call<String> sendTextToMid(String text);

}
