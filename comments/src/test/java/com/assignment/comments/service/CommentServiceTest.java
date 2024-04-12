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

        // Calling the service method
        List<Comment> comments = commentService.retriveallthecomments();

        // Verifying the results
        assertEquals(2, comments.size());
        // You can add more assertions to verify the content of comments if needed
    }

    @Test
    public void testRetrieveCommentsByUsername() {
        String username = "rohit";
        List<Comment> mockComments = new ArrayList<>();
        mockComments.add(comment1);
        when(commentRepository.findCommentByBy(username)).thenReturn(mockComments);

        List<Comment> comments = commentService.retrievcommentbyusername(username);

        assertEquals(1, comments.size());
        // You can add more assertions to verify the content of comments if needed
    }

    @Test
    public void testRetrieveCommentsByDate() {
        LocalDate date = LocalDate.now();
        List<Comment> mockComments = new ArrayList<>();
        mockComments.add(new Comment(/* comment details here */));
        when(commentRepository.findCommentByDateOfComment(date)).thenReturn(mockComments);

        List<Comment> comments = commentService.retrivecommentsbydate(date);

        assertEquals(1, comments.size());
        // You can add more assertions to verify the content of comments if needed
    }

    @Test
    public void testAddValue() {
        Comment commentToAdd = new Comment(/* comment details here */);
        LocalDate today = LocalDate.now();
        when(commentRepository.save(any(Comment.class))).thenReturn(commentToAdd);

        Comment addedComment = commentService.addvalue(commentToAdd);

        assertEquals(today, addedComment.getDateOfComment());
        // You can add more assertions to verify other properties of the addedComment if needed
    }
}
