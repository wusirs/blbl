package com.heisenberg.blbl.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heisenberg.blbl.domain.Comment;
import com.heisenberg.blbl.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CommentController {
    @Resource
    private CommentService commentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @GetMapping("hello")
    public List<Comment> helloGet(String username) {
        LOGGER.info(username);
        List<Comment> comments = commentService.queryAll();
        LOGGER.info(comments.toString());
        return comments;
    }

    @PostMapping("hello")
    public String helloPost() {
        return "post hello world！";
    }


    @GetMapping("byCondition")
    public List<Comment> byCondition(String username) throws ParseException {
        LOGGER.info(username);
        List<Comment> comments = commentService.byCondition();
        LOGGER.info(comments.toString());
        return comments;
    }

    @PostMapping("queryByCondition")
    public List<Comment> queryByCondition(@RequestBody Map<String, Object> params) {
        return commentService.queryByCondition(params);
    }

    @PostMapping("queryByWrapper")
    public IPage<Comment> queryByWrapper(@RequestBody JSONObject queryCondition) {
        return commentService.queryByWrapper(queryCondition);
    }
}

