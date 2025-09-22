package com.jonasesteves.posts.service.domain.service;

import com.jonasesteves.posts.service.api.domain.PostDataResponse;
import com.jonasesteves.posts.service.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void postPriceUpdate(PostDataResponse postDataResponse) {
        postRepository.findById(UUID.fromString(postDataResponse.getPostId())).ifPresent(post -> {
            post.setWordCount(postDataResponse.getWordCount());
            post.setCalculatedValue(postDataResponse.getCalculatedValue());
            postRepository.save(post);
        });
    }
}
