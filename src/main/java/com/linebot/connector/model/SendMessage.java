package com.linebot.connector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by han on 2016. 4. 12..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessage extends Message {
    String eventType = "138311608800106203";
}
