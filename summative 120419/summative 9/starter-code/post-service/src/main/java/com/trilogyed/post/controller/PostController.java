package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDao postdao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return postdao.addPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        Post post = postdao.getPost(id);

        if(post == null){
            throw new NotFoundException(("the post w/that id doesnt exist"));
        }
        return postdao.getPost(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)

    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        postdao.updatePost(post);

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        Post post = postdao.getPost(id);

        if(post == null){
            throw new NotFoundException(("that post does not exist"));
        }
        postdao.deletePost(id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {

        return postdao.getAllPosts();
    }

    @GetMapping("/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostsByUser(@PathVariable String posterName) {

        return postdao.getPostsByUser(posterName);
    }
}


