package com.yuan.service;

import com.yuan.constant.CacheCode;
import com.yuan.response.UserDetailsResponse;
import org.springframework.cache.annotation.Cacheable;

public interface ISoulUserService {
    @Cacheable(value = CacheCode.USERDETAILS, condition = "#result!='null'", key = "#id")
    UserDetailsResponse getDetailsById(Integer id);

//    @CacheEvict(value ="", allEntries = true)
}
