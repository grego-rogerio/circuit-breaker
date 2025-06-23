package com.circuit.breaker.service;

import com.circuit.breaker.client.CommentClient;
import com.circuit.breaker.domain.Comment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentClient commentClient;

    @Autowired
    private RedisService redisService;

    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String id) {
        var comments = commentClient.getComments(id);
        redisService.save(comments, id);
        return comments;
    }

    private List<Comment> getCommentsFallback(String id, Throwable cause) {
       return redisService.findById(id);
    }

}
