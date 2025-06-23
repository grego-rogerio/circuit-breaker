package com.circuit.breaker.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Publication {

    private String id;

    private String title;
    private String imageUrl;
    private String text;
    private List<Comment> comments;

    public Publication() {
    }

    public Publication(String id, String title, String imageUrl, String text, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.comments = comments;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
