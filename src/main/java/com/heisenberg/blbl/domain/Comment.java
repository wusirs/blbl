package com.heisenberg.blbl.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user_comment")
public class Comment {
//    @JsonFormat(pattern = "cid")
//    @JsonProperty("cid")
    @JsonAlias("cid")
    @TableField(value = "cid")
//    @TableId(value = "cid")
    private Integer cId;

    private Integer prevComment;

    private Integer userId;

    private Integer relateComment;

    private String content;

    private Integer videoId;

    private Date commentTime;
}
