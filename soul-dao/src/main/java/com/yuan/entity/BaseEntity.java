package com.yuan.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;


/**
 * 通用实体对象
 */
@Data
class BaseEntity implements Serializable {
    @TableField(value = "add_time", fill = FieldFill.INSERT, jdbcType = JdbcType.TIMESTAMP)
    private Date addTime; //添加时间
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.TIMESTAMP)
    private Date updateTime; //跟新时间
    @TableField("add_user")
    private String addUser; //添加人
    @TableField("update_user")
    private String updateUser; //更新人
    @TableLogic // 逻辑删除
    @TableField(value = "is_del", jdbcType = JdbcType.INTEGER, fill = FieldFill.INSERT)
    private Integer isDel;
}
