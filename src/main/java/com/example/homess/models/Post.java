package com.example.homess.models;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Post {
    int uid;
    int userUid;
    int categoryUid;
    int ageUid;
    String postTitle;
    String postContent;
    int postHits;
    int postLike;
    LocalDateTime postCreatedAt;
    String deleteyn;
}
