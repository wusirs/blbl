package com.heisenberg.blbl.controller;

import com.heisenberg.blbl.domain.Comment;
import com.heisenberg.blbl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CommentController {
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

    @PostMapping("queryByCondition")
    public List<Comment> queryByCondition(@RequestBody Map<String, Object> params){
        List<Comment> comments = commentService.queryByCondition(params);
        return comments;
    }
}

