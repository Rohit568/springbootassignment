package com.assignment.comments.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username",nullable = false)
    private String by;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private LocalDate dateOfComment;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateOfComment(LocalDate dateOfComment) {
        this.dateOfComment = dateOfComment;
    }



    public String getBy() {
        return by;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDateOfComment() {
        return dateOfComment;
    }
}
