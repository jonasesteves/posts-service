package com.jonasesteves.posts.service.api.controller;

import com.jonasesteves.posts.service.api.domain.PostData;
import com.jonasesteves.posts.service.api.domain.PostInput;
import com.jonasesteves.posts.service.api.domain.PostOutput;
import com.jonasesteves.posts.service.api.domain.PostSummaryOutput;
import com.jonasesteves.posts.service.commons.IdGenerator;
import com.jonasesteves.posts.service.domain.model.Post;
import com.jonasesteves.posts.service.domain.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static com.jonasesteves.posts.service.infrastructure.rabbitmq.RabbitMQConfig.FANOUT_EXCHANGE_NAME;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final RabbitTemplate rabbitTemplate;

    public PostController(PostRepository postRepository, RabbitTemplate rabbitTemplate) {
        this.postRepository = postRepository;
        this.rabbitTemplate = rabbitTemplate;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostSummaryOutput createPost(@RequestBody @Valid PostInput postInput) {
        Post post = Post.builder()
                .id(IdGenerator.generateTimeBasedUUID())
                .title(postInput.getTitle())
                .body(postInput.getBody())
                .author(postInput.getAuthor())
                .build();

        post = postRepository.saveAndFlush(post);

        PostData postData = new PostData(post.getId().toString(), post.getBody());

        rabbitTemplate.convertAndSend(FANOUT_EXCHANGE_NAME, "", postData);

        return convertToSummaryOutput(post);
    }

    @GetMapping("{id}")
    public PostOutput findById(@PathVariable UUID id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToModel(post);
    }

    @GetMapping
    public Page<PostSummaryOutput> findAll(Pageable  pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(PostController::convertToSummaryOutput);
    }

    private static PostOutput convertToModel(Post post) {
        return PostOutput.builder()
                .id(post.getId().toString())
                .title(post.getTitle())
                .body(post.getBody())
                .author(post.getAuthor())
                .wordCount(post.getWordCount())
                .calculatedValue(post.getCalculatedValue())
                .build();
    }

    private static PostSummaryOutput convertToSummaryOutput(Post post) {
        return PostSummaryOutput.builder()
                .id(post.getId().toString())
                .title(post.getTitle())
                .summary(post.getBody())
                .author(post.getAuthor())
                .build();
    }
}
