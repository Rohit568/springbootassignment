package com.assignment.comments.service;


import com.assignment.comments.entity.Comment;
import com.assignment.comments.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    Comment comment1;
    Comment comment2;

    @BeforeEach
    public void setup(){
        comment1 = new Comment();
        comment1.setId(2);
        comment1.setDateOfComment(LocalDate.parse("2024-04-12"));
        comment1.setText("test1");
        comment1.setBy("rohit");
        comment2 = new Comment();
        comment2.setId(3);
        comment2.setDateOfComment(LocalDate.parse("2024-04-12"));
        comment2.setText("test2");
        comment2.setBy("ankit");


    }

    @Test
    public void testRetrieveAllComments() {
        // Mocking the behavior of CommentRepository
        List<Comment> mockComments = new ArrayList<>();
        mockComments.add(comment1);
        mockComments.add(comment2);
        when(commentRepository.findAll()).thenReturn(mockComments);
        List<Comment> comments = commentService.retriveallthecomments();

        assertEquals(2, comments.size());
    }

    @Test
    public void testRetrieveCommentsByUsername() {
        String username = "rohit";
        List<Comment> mockComments = new ArrayList<>();
        mockComments.add(comment1);
        when(commentRepository.findCommentByBy(username)).thenReturn(mockComments);

        List<Comment> comments = commentService.retrievcommentbyusername(username);

        assertEquals(1, comments.size());
    }

    @Test
    public void testRetrieveCommentsByDate() {
        LocalDate date = LocalDate.now();
        List<Comment> mockComments = new ArrayList<>();
        mockComments.add(comment1);
        when(commentRepository.findCommentByDateOfComment(date)).thenReturn(mockComments);

        List<Comment> comments = commentService.retrivecommentsbydate(date);

        assertEquals(1, comments.size());
    }

    @Test
    public void testAddValue() {

        LocalDate today = LocalDate.now();
        when(commentRepository.save(any(Comment.class))).thenReturn(comment1);

        Comment addedComment = commentService.addvalue(comment1);

        assertEquals(today, addedComment.getDateOfComment());
    }
}
