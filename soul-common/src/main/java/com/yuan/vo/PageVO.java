package com.yuan.vo;

import lombok.Data;

@Data
public class PageVO {
    private Integer offset = 0; // 起始数据(表示从0开始的页数)
    private Integer limit = 10; // 每页限制大小
}
