package com.example.homess.mappers;

import com.example.homess.dtos.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(PostDto post);
    List<PostDto> selectPosts();
    PostDto selectDetailPost(int uid);
}
