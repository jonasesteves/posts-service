package com.jonasesteves.posts.service.api.domain;

import com.jonasesteves.posts.service.domain.model.Post;

import java.math.BigDecimal;
import java.util.Objects;

public class PostOutput {
    private String id;
    private String title;
    private String body;
    private String author;
    private Integer wordCount;
    private BigDecimal calculatedValue;

    private PostOutput() {}

    public PostOutput(String id, String title, String body, String author, Integer wordCount, BigDecimal calculatedValue) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.wordCount = wordCount;
        this.calculatedValue = calculatedValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        PostOutput that = (PostOutput) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(author, that.author) && Objects.equals(wordCount, that.wordCount) && Objects.equals(calculatedValue, that.calculatedValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, author, wordCount, calculatedValue);
    }

    @Override
    public String toString() {
        return "PostOutput{" +
                "id='" + id + '\'' +
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
        private String id;
        private String title;
        private String body;
        private String author;
        private Integer wordCount;
        private BigDecimal calculatedValue;

        public Builder id(String id) {
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

        public PostOutput build() {
            return new PostOutput(id, title, body, author, wordCount, calculatedValue);
        }

        @Override
        public String toString() {
            return "PostOutput.Builder{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    ", author='" + author + '\'' +
                    ", wordCount=" + wordCount +
                    ", calculatedValue=" + calculatedValue +
                    '}';
        }
    }
}
