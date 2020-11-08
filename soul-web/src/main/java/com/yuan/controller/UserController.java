package com.yuan.controller;

import com.yuan.response.UserDetailsResponse;
import com.yuan.service.ISoulUserService;
import com.yuan.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户接口
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    private ISoulUserService iSoulUserService;

    /**
     * 用户详情
     *
     * @param id
     * @return
     */
    @GetMapping("details/{id}")
    public ResultVO<UserDetailsResponse> treeCamera(@Min(1) @Length(min = 1, max = 10) @NotNull(message = "id不能为空") @PathVariable Integer id) {
        return ResultVO.success(iSoulUserService.getDetailsById(id));
    }

}
