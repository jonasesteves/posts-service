package com.jonasesteves.posts.service.api.domain;

public class PostData {
    private String postId;
    private String postBody;

    private PostData() {}

    public PostData(String postId, String postBody) {
        this.postId = postId;
        this.postBody = postBody;
    }
}
