package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {


    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    CommentViewModel addComment(@Valid @RequestBody Comment comment);

    @RequestMapping(value = "/comments/posts/{id}", method = RequestMethod.GET)
    List<String> getCommentsByPostId(@PathVariable int id);
}
