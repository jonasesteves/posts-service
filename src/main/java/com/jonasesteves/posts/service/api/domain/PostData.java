package com.jonasesteves.posts.service.api.domain;

public class PostData {
    private String postId;
    private String postBody;

    private PostData() {}

    public PostData(String postId, String postBody) {
        this.postId = postId;
        this.postBody = postBody;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }


}
