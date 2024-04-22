package com.example.homess.controllers;

import com.example.homess.dtos.PostDto;
import com.example.homess.mappers.PostMapper;
import com.example.homess.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    PostMapper postMapper;

    @PostMapping("/postwrite")
    public void postwrite(@RequestBody PostDto postDto){
        postService.postwrite(postDto);
        int userUid = (int)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postDto.setUserUid(userUid);
        postMapper.insertPost(postDto);
    }

    @GetMapping("/postlist")
    @ResponseBody
    public List<PostDto> postlist(){
        return postMapper.selectPosts();
    }

    @GetMapping("/postview")
    public PostDto postview(@RequestParam(name = "uid")int uid){
        return postMapper.selectDetailPost(uid);
    }




}