package com.heisenberg.blbl.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heisenberg.blbl.domain.Comment;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> queryAll();
    List<Comment> byCondition() throws ParseException;
    List<Comment> queryByCondition(Map<String, Object> params);
    IPage<Comment> queryByWrapper(JSONObject queryCondition);
}
