package com.ljw.entity.system;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : lijianwen
 * @Date : 2020-05-19
 * @Version : 1.0
 */
@Getter
@Setter
public class UserDto {
    private int id;
    private String userId;
    private String userName;
    private String password;
    private String tel;
    private String status;


}
