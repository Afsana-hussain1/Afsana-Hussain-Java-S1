package com.trilogyed.stwitter.controller;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RefreshScope
@CacheConfig(cacheNames = {"posts"})

public class StwitterController {

    @Autowired
    ServiceLayer serviceLayer;

    @CachePut(key = "#result.getPostId")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    PostViewModel addPost(@Valid @RequestBody PostViewModel post) throws InterruptedException {
        System.out.println(" *-*-*-* CREATING NEW POST *-*-*-*  ");
        return serviceLayer.addPost(post);

    }
    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    PostViewModel getPost(@PathVariable int id) {
        System.out.println(" *-*-*-* GETTING POST ID = " + id + " *-*-*-* ");
        return serviceLayer.getPost(id);

    }

    @Cacheable
    @RequestMapping(value = "posts/user/{posterName}", method = RequestMethod.GET)
    List<PostViewModel> getPostsByPosterName(@PathVariable String posterName) {
        System.out.println(" *-*-*-* GETTING POSTS BY = " + posterName + " *-*-*-* ");
        return serviceLayer.getPostbynameOfposter(posterName);

    }

}


