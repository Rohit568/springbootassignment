package com.assignment.comments.repository;

import com.assignment.comments.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByBy(String username);
    List<Comment> findCommentByDateOfComment(LocalDate date);
}