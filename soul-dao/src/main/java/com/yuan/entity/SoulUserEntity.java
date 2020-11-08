package com.yuan.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("soul_user")
@KeySequence(value = "seq_soul_user_id", clazz = int.class)
public class SoulUserEntity implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    @TableField(value = "nick_name")
    private String nickName;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "password")
    private Integer password;
    @TableField(value = "md5_password")
    private String md5Password;
}
