package com.jonasesteves.posts.service.api.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class PostInput {

    @NotBlank
    private String title;

    @NotBlank
    private String body;

    @NotBlank
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PostInput postInput = (PostInput) o;
        return Objects.equals(title, postInput.title) && Objects.equals(body, postInput.body) && Objects.equals(author, postInput.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, author);
    }

    @Override
    public String toString() {
        return "PostInput{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
