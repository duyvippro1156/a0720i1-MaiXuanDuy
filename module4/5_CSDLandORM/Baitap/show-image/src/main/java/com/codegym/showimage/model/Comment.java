package com.codegym.showimage.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private long rating;
    private String author;
    private String feedback;
    private int reaction;

    public Comment() {
    }

    public Comment(long rating, String author, String feedback, int reaction){
        this.rating = rating;
        this.author = author;
        this.feedback = feedback;
        this.reaction = reaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int like) {
        this.reaction = like;
    }
}

