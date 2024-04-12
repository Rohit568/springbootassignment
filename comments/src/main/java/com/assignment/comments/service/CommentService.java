package com.assignment.comments.service;

import com.assignment.comments.entity.Comment;


import java.time.LocalDate;
import java.util.List;

public interface CommentService {


    List<Comment> retriveallthecomments();
    List<Comment> retrievcommentbyusername(String username);

    List<Comment> retrivecommentsbydate(LocalDate date);

    Comment addvalue(Comment comment);
}
