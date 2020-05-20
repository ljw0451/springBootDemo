package com.ljw.mapper.system;

import com.ljw.entity.system.ResDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : lijianwen
 * @Date : 2020-05-19
 * @Version : 1.0
 */
@Repository
public interface SysResMapper {
    /**
     * 根据角色ID查询角色对应的权限信息
     * @param roleId
     * @return
     */
    List<ResDto> findPermissionByRoleId(@Param("roleId") String roleId);
}
