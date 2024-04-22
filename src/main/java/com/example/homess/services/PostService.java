package com.example.homess.services;

import com.example.homess.dtos.PostDto;
import com.example.homess.mappers.PostMapper;
import com.example.homess.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;

    public void postwrite(PostDto postDto){
        Post post = Post.builder()
                .userUid(postDto.getUserUid())
                .categoryUid(postDto.getCategoryUid())
                .ageUid(postDto.getAgeUid())
                .postTitle(postDto.getPostTitle())
                .postContent(postDto.getPostContent())
                .build();
    }

}
