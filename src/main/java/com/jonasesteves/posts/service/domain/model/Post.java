package com.jonasesteves.posts.service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Post {

    @Id
    private UUID id;
    private String title;
    private String body;
    private String author;
    private Integer wordCount;
    private BigDecimal calculatedValue;

    private Post() {}

    public Post(UUID id, String title, String body, String author, Integer wordCount, BigDecimal calculatedValue) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.wordCount = wordCount;
        this.calculatedValue = calculatedValue;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public BigDecimal getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(BigDecimal calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(body, post.body) && Objects.equals(author, post.author) && Objects.equals(wordCount, post.wordCount) && Objects.equals(calculatedValue, post.calculatedValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, author, wordCount, calculatedValue);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", wordCount=" + wordCount +
                ", calculatedValue=" + calculatedValue +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String title;
        private String body;
        private String author;
        private Integer wordCount;
        private BigDecimal calculatedValue;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder wordCount(Integer wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        public Builder calculatedValue(BigDecimal calculatedValue) {
            this.calculatedValue = calculatedValue;
            return this;
        }

        public Post build() {
            return new Post(id, title, body, author, wordCount, calculatedValue);
        }

        @Override
        public String toString() {
            return "Post.Builder{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    ", author='" + author + '\'' +
                    ", wordCount=" + wordCount +
                    ", calculatedValue=" + calculatedValue +
                    '}';
        }
    }
}
