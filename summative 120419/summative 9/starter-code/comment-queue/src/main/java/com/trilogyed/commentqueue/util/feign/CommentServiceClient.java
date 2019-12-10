package com.trilogyed.commentqueue.util.feign;

import com.trilogyed.commentqueue.util.feign.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment addComment(Comment comment);

}
