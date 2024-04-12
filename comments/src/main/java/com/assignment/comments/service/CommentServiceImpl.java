package com.assignment.comments.service;


import com.assignment.comments.entity.Comment;
import com.assignment.comments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService
{
   @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> retriveallthecomments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> retrievcommentbyusername(String username) {
        return commentRepository.findCommentByBy(username);
    }

    @Override
    public List<Comment> retrivecommentsbydate(LocalDate date) {
        return commentRepository.findCommentByDateOfComment(date);
    }

    @Override
    public Comment addvalue(Comment comment) {
        LocalDate date = LocalDate.now();
        comment.setDateOfComment(date);
        Comment comment1 =  commentRepository.save(comment);
        return comment1;
    }
}
