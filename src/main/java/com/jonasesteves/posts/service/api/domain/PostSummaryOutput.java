package com.jonasesteves.posts.service.api.domain;

import java.util.Objects;

public class PostSummaryOutput {
    private String id;
    private String title;
    private String summary;
    private String author;

    private PostSummaryOutput() {}

    public PostSummaryOutput(String id, String title, String summary, String author) {
        this.id = id;
        this.title = title;
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(summary, that.summary) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, summary, author);
    }

    @Override
    public String toString() {
        return "PostSummaryOutput{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String title;
        private String summary;
        private String author;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public PostSummaryOutput build() {
            return new PostSummaryOutput(id, title, summary, author);
        }

        @Override
        public String toString() {
            return "PostSummaryOutput.Builder{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", summary='" + summary + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }
}
