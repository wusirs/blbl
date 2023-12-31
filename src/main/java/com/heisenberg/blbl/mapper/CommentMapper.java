package com.heisenberg.blbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heisenberg.blbl.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> queryAll();

    List<Comment> queryByCondition(Map<String, Object> params);
}
