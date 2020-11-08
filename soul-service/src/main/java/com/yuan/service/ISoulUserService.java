package com.yuan.service;

import com.yuan.response.UserDetailsResponse;

public interface ISoulUserService {
    UserDetailsResponse getDetailsById(Integer id);
}
