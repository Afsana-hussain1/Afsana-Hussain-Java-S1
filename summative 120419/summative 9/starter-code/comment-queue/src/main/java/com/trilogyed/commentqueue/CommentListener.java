package com.trilogyed.commentqueue;


import com.trilogyed.commentqueue.util.feign.CommentServiceClient;
import com.trilogyed.commentqueue.util.feign.model.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class CommentListener {

    @Autowired
    private CommentServiceClient client;

    @RabbitListener(queues = CommentQueueApplication.QUEUE_NAME)
    public void recieveComment(Comment comment) {
        System.out.println("Comment sent through stwitterservice");
        System.out.println(comment);

        comment.setCommenterName("Bob");
        comment.setCreateDate(LocalDate.now());
        comment = client.addComment(comment);

        System.out.println("Created: " + comment);
    }
}
