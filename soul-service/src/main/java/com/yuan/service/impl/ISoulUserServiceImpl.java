package com.yuan.service.impl;

import com.yuan.response.UserDetailsResponse;
import com.yuan.service.ISoulUserService;
import com.yuan.service.datalayer.SoulUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ISoulUserServiceImpl implements ISoulUserService {

    @Autowired
    private SoulUserService soulUserService;

    @Override
    public UserDetailsResponse getDetailsById(Integer id) {
        UserDetailsResponse detailsById = soulUserService.getDetailsById(id);
        return detailsById;
    }
}
