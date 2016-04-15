package com.linebot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.linebot.user.model.User;

/**
 * Created by han on 2016. 4. 15..
 */
public interface UserInfoRepository<T extends User> extends MongoRepository<T, String> {
    User findByMid(String mid);
    User findById(String id);
}
