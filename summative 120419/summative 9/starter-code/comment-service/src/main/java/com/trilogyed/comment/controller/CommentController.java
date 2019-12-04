package com.trilogyed.comment.controller;
import com.sun.jersey.api.NotFoundException;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/comments")
@RestController
@RefreshScope
public class CommentController {
    @Autowired
    CommentDao dao;

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Comment addComment(@Valid @RequestBody Comment comment) {

        return dao.addComment(comment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {

        Comment comment = dao.getComment(id);

        if(comment == null){
            throw new NotFoundException(("No Comment with this id exists"));
        }
        return dao.getComment(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments() {

        return dao.getAllComments();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@Valid @RequestBody Comment comment, @PathVariable int id) {

        dao.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {

        Comment comment = dao.getComment(id);

        if(comment == null){
            throw new NotFoundException(("No Comment with this id exists"));
        }
        dao.deleteComment(id);
    }


}
