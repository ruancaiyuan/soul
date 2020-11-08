package com.yuan.response;

import lombok.Data;

@Data
public class UserDetailsResponse {
    private Integer id;//用户Id
    private String nickName;//昵称
    private String userName;//姓名
    private Integer password;//密码
    private String md5Password;//加密的密码
}
