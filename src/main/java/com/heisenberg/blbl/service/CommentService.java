package com.heisenberg.blbl.service;

import com.heisenberg.blbl.domain.Comment;

import java.text.ParseException;
import java.util.List;

public interface CommentService {
    List<Comment> queryAll();
    List<Comment> byCondition() throws ParseException;
}
