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
public class ResDto {
    private int id;
    private String resId;
    private String resName;
    private String parentResid;
    private String url;
    private String level;

}
