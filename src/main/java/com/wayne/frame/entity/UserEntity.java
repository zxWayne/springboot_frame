package com.wayne.frame.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author xzhang
 * @date 2019-12-11 12:48
 **/
@Data
@TableName("sys_user")
public class UserEntity {

    private Integer id;

    private String password;

    private String remarks;

    private String userName;

    private String type;

    @TableField(fill = FieldFill.INSERT)
    private LocalDate da;


}
