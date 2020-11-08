package com.yuan.service;

import com.yuan.response.UserDetailsResponse;
import org.springframework.cache.annotation.Cacheable;

public interface ISoulUserService {
    @Cacheable(value = "userDetails", condition = "#result!='null'", key = "#id")
    UserDetailsResponse getDetailsById(Integer id);

//    @CacheEvict(value ="", allEntries = true)
}
