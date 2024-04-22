package com.example.homess.mappers;

import com.example.homess.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void addUser(User user);

    Optional<User> findUser(String userId);
}
