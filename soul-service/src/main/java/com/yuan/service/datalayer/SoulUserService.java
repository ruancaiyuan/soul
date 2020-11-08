package com.yuan.service.datalayer;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.entity.SoulUserEntity;
import com.yuan.mapper.SoulUserMapper;
import com.yuan.response.UserDetailsResponse;
import com.yuan.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SoulUserService extends ServiceImpl<SoulUserMapper, SoulUserEntity> {

    public UserDetailsResponse getDetailsById(Integer id) {
        SoulUserEntity soulUserEntity = this.getById(id);
        ObjectUtils.isNull(soulUserEntity, "没有该用户");
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        BeanUtil.copyProperties(soulUserEntity, userDetailsResponse);
        return userDetailsResponse;
    }
}
