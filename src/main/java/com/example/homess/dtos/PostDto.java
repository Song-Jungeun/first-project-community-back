package com.example.homess.dtos;


import java.time.LocalDateTime;

public class PostDto {
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

    @Override
    public String toString() {
        return "PostDto{" +
                "uid=" + uid +
                ", userUid=" + userUid +
                ", categoryUid=" + categoryUid +
                ", ageUid=" + ageUid +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postHits=" + postHits +
                ", postLike=" + postLike +
                ", postCreatedAt=" + postCreatedAt +
                ", deleteyn='" + deleteyn + '\'' +
                '}';
    }

    public PostDto() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUserUid() {
        return userUid;
    }

    public void setUserUid(int userUid) {
        this.userUid = userUid;
    }

    public int getCategoryUid() {
        return categoryUid;
    }

    public void setCategoryUid(int categoryUid) {
        this.categoryUid = categoryUid;
    }

    public int getAgeUid() {
        return ageUid;
    }

    public void setAgeUid(int ageUid) {
        this.ageUid = ageUid;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPostHits() {
        return postHits;
    }

    public void setPostHits(int postHits) {
        this.postHits = postHits;
    }

    public int getPostLike() {
        return postLike;
    }

    public void setPostLike(int postLike) {
        this.postLike = postLike;
    }

    public LocalDateTime getPostCreatedAt() {
        return postCreatedAt;
    }

    public void setPostCreatedAt(LocalDateTime postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }

    public String getDeleteyn() {
        return deleteyn;
    }

    public void setDeleteyn(String deleteyn) {
        this.deleteyn = deleteyn;
    }
}

