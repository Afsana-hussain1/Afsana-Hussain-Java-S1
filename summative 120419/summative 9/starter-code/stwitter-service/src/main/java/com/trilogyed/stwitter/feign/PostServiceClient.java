package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    Post getPost(@PathVariable int id);

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    Post addPost(Post post);


    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    List<Post> getPostsByPosterName(@PathVariable String poster_name);

    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    List<Post>getAllPosts();

}
