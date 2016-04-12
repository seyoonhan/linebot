package com.linebot.connector.model;

/**
 * Created by han on 2016. 4. 12..
 */
public enum OperationType {
    ADD_FRIEND(4), BLOCK(8);

    int operation;

    OperationType(int op){
        this.operation = op;
    }

}
