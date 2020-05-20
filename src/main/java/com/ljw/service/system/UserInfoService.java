package com.ljw.service.system;

import com.ljw.entity.system.UserDto;
import com.ljw.mapper.system.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : lijianwen
 * @Date : 2020-05-19
 * @Version : 1.0
 */
@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserDto findByUsername(String userName) {
        return userInfoMapper.findByUsername(userName);
    }

}
