package com.heisenberg.blbl.controller;

import com.heisenberg.blbl.domain.Comment;
import com.heisenberg.blbl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
public class TestController {
    @Autowired
    private CommentService commentService;

    @GetMapping("hello")
    public List<Comment> helloGet(String username) {
        System.out.println(username);
        List<Comment> comments = commentService.queryAll();
        System.out.println(comments);
        return comments;
    }

    @PostMapping("hello")
    public String helloPost() {
        return "post hello world！";
    }


    @GetMapping("byCondition")
    public List<Comment> byCondition(String username) throws ParseException {
        System.out.println(username);
        List<Comment> comments = commentService.byCondition();
        System.out.println(comments);
        return comments;
    }

}

