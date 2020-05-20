package com.ljw.mapper.system;

import com.ljw.entity.system.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author : lijianwen
 * @Date : 2020-05-19
 * @Version : 1.0
 */
@Repository
public interface UserInfoMapper {
    /**
     * 通过username查找用户角色信息
     * @param username
     * @return
     */
    UserDto findByUsername(@Param("username") String username);
}
