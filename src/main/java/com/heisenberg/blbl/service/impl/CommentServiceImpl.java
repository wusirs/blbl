package com.heisenberg.blbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heisenberg.blbl.domain.Comment;
import com.heisenberg.blbl.mapper.CommentMapper;
import com.heisenberg.blbl.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public List<Comment> queryAll() {
        List<Comment> comments = commentMapper.queryAll();
        logger.info(String.format("评论: %s", comments));
        return comments;
    }

    @Override
    public List<Comment> byCondition() throws ParseException {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_id", "2001");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2023-07-28 12:00:00");
        Date date2 = sdf.parse("2023-07-29 12:00:00");
        Date date3 = null;
        Date date4 = null;
        Date date5 = sdf.parse("2023-12-01 12:00:00");
        Date date6 = sdf.parse("2023-12-31 12:00:00");

        if (date1 != null) {
            logger.error("报错了！！！！");
        }


        // 如果三组日期都为空，或者任意一组日期为空，那么会组装出错误的sql，执行会报错。
//             @存在日期为null时，可能为报错
        /**queryWrapper.and(wrapper -> wrapper
         .or ().or(
         wrapper_1 -> wrapper_1.func ( i -> {
         if ( Objects.nonNull ( date1)) {
         i.ge("comment_time", date1);
         }
         }).func(j -> {
         if (Objects.nonNull(date2)) {
         j.le("comment_time", date2);
         }
         }))
         .or().or(
         wrapper_2 -> wrapper_2.func(i -> {
         if (Objects.nonNull(date3)) {
         i.ge("comment_time", date3);
         }
         }).func(j -> {
         if (Objects.nonNull(date4)) {
         j.le("comment_time", date4);
         }
         }))
         .or().or(
         wrapper_3 -> wrapper_3.func(i -> {
         if (Objects.nonNull(date5)) {
         i.ge("comment_time", date5);
         }
         }).func(j -> {
         if (Objects.nonNull(date6)) {
         j.le("comment_time", date6);
         }
         }))
         );*/

        // https://blog.csdn.net/clevermeng123/article/details/120870820
        /*
        所以需要在任意一组日期为空的时候，需要加判断，去掉or / and 结构。
        可以使用or(boolean condition, Consumer<Children> consumer)方法。
        boolean  condition这个参数可以加入自己的判断，如果为false，那么这个or的结构体整个去掉。
        */

        queryWrapper.and(wrapper -> {
                    String commentTime = "comment_time";
                    wrapper.or().or(!(Objects.isNull(date1) && Objects.isNull(date2)),
                                    wrapperDate -> wrapperDate
                                            .func(i -> timeGe(i, date1, commentTime))
                                            .func(j -> timeLe(j, date2, commentTime)))
                            .or().or(!(Objects.isNull(date3) && Objects.isNull(date4)),
                                    wrapperDate -> wrapperDate
                                            .func(i -> timeGe(i, date3, commentTime))
                                            .func(j -> timeLe(j, date4, commentTime)))
                            .or().or(!(Objects.isNull(date5) && Objects.isNull(date6)),
                                    wrapperDate -> wrapperDate
                                            .func(i -> timeGe(i, date5, commentTime))
                                            .func(j -> timeLe(j, date6, commentTime)));
                }
        );

        List<Comment> comments = commentMapper.selectList(queryWrapper);
        logger.info(String.format("评论: %s", comments));

        return comments;
    }

    private static void timeLe(QueryWrapper<Comment> j, Date date2, String commentTime) {
        if (Objects.nonNull(date2)) {
            j.le(commentTime, date2);
        }
    }

    private static void timeGe(QueryWrapper<Comment> i, Date date1, String commentTime) {
        if (Objects.nonNull(date1)) {
            i.ge(commentTime, date1);
        }
    }

    @Override
    public List<Comment> queryByCondition(Map<String, Object> params) {
        return commentMapper.queryByCondition(params);
    }

    @Override
    public List<Comment> queryByWrapper() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2023-07-28 12:01:00");
        Date date2 = sdf.parse("2023-07-29 12:02:00");
        Date date3 = sdf.parse("2023-07-28 12:02:00");
        Date date4 = sdf.parse("2023-07-29 12:02:00");
        Date date5 = sdf.parse("2023-12-01 12:00:00");
        Date date6 = sdf.parse("2023-12-31 12:00:00");

        String commentTime = "comment_time";
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper
                .and(wrapper -> wrapper.ge(commentTime, date1).or().le(commentTime, date2))
                .and(wrapper -> wrapper.ge(commentTime, date3).or().le(commentTime, date4)).
                and(wrapper -> wrapper.ge(commentTime, date5).or().le(commentTime, date6));
        return commentMapper.selectList(commentQueryWrapper);
    }
}
