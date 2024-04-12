package com.assignment.comments.controller;


import com.assignment.comments.entity.Comment;
import com.assignment.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("api/v2/comments")
public class CommentController
{
    @Autowired
    private CommentService commentService;


    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.retriveallthecomments();
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addValue(@RequestBody Comment comment)
    {
        Comment comment1 = commentService.addvalue(comment);
        return ResponseEntity.ok(comment1);

    }



    @GetMapping("/search")
    public ResponseEntity<List<Comment>> getCommentsByUsername(@RequestParam(value = "date", required = false) String date,
                                                               @RequestParam(value = "username", required = false) String username) {
        try{
            if(date == null)
                date = "adb";
            System.out.println("20938983");
            LocalDate date1 = LocalDate.parse(date);

            List<Comment> comments = commentService.retrivecommentsbydate(date1);

            return ResponseEntity.ok(comments);

        }
        catch(DateTimeParseException ex){


            List<Comment> comments = commentService.retrievcommentbyusername(username);

            return ResponseEntity.ok(comments);
        }

    }

}
