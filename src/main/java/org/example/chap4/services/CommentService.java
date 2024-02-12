package org.example.chap4.services;

import org.example.chap4.proxies.CommentNotificationProxy;
import org.example.chap4.repositories.Comment;
import org.example.chap4.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Lazy
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository ;

    @Autowired
    @Qualifier("PUSH")
    private CommentNotificationProxy commentNotificationProxy;

//    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
//        System.out.println("CommentService 생성!");
//        this.commentRepository = commentRepository;
//        this.commentNotificationProxy = commentNotificationProxy;
//    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }


}
