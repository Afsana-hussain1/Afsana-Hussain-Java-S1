package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.exceptions.NotFoundExceptions;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDao postdao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody @Valid Post post) {
        return postdao.addPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        Post post = postdao.getPost(id);

        if(post == null){
            throw new NotFoundExceptions(("the post w/that id doesn't exist"));
        }
        return postdao.getPost(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        postdao.updatePost(post);

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        Post post = postdao.getPost(id);

        if(post == null){
            throw new NotFoundExceptions(("that post does not exist"));
        }
        postdao.deletePost(id);

    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {

        return postdao.getAllPosts();
    }

    @GetMapping("/posts/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostsByUser(@PathVariable String posterName) {

        return postdao.getPostsByUser(posterName);
    }
}


