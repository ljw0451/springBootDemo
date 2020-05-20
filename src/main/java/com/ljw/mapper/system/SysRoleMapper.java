package com.ljw.mapper.system;

import com.ljw.entity.system.RoleDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : lijianwen
 * @Date : 2020-05-19
 * @Version : 1.0
 */
@Repository
public interface SysRoleMapper {
    /**
     * 通过username查找用户角色信息
     * @param username
     * @return
     */
    List<RoleDto> findRoleByUsername(@Param("username") String username);
}
