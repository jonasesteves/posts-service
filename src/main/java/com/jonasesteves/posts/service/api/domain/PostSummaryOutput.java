package com.jonasesteves.posts.service.api.domain;

import java.util.Objects;

public class PostSummaryOutput {
    private String id;
    private String title;
    private String body;
    private String author;

    private PostSummaryOutput() {}

    public PostSummaryOutput(String id, String title, String body, String author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PostSummaryOutput that = (PostSummaryOutput) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, author);
    }

    @Override
    public String toString() {
        return "PostSummaryOutput{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
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

        public PostSummaryOutput build() {
            return new PostSummaryOutput(id, title, body, author);
        }

        @Override
        public String toString() {
            return "PostSummaryOutput.Builder{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }
}
