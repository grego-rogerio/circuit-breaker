package com.circuit.breaker.client;

import com.circuit.breaker.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CommentClient", url = "${client.comments.url}")
public interface CommentClient {

     @GetMapping("/comments/{publicationId}")
     List<Comment> getComments(@PathVariable("publicationId") String publicationId);

}
