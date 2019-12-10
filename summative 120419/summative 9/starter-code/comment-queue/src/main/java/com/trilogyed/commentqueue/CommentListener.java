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
    public void recieveComment(Map<String, Integer> commentList) {
        System.out.println("Comment sent through stwitterservice");
        System.out.println(commentList);

        commentList.entrySet().stream()
                .forEach(comment -> {
                    System.out.println("----QUEUE---");
                    System.out.println(comment);
                    System.out.println("Creating");
                    Comment comment1 = new Comment();
                    comment1.setPostId(comment.getValue());
                    comment1.setComment(comment.getKey());
                    comment1.setCreateDate(LocalDate.now());
                    comment1.setCommenterName("N/A");
                    System.out.println(client.addComment(comment1));
                });
    }
}
