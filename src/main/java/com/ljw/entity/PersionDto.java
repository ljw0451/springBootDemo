package com.ljw.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : lijianwen
 * @Date : 2020-05-15
 * @Version : 1.0
 */
@Getter
@Setter
public class PersionDto {
    private Integer id;
    private String username;
    private String zone;
    private String email;
    private String sex;
    private String phone;
    private String createTime;
}
