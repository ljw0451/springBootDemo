package com.ljw.service;

import com.ljw.entity.PersionDto;
import com.ljw.mapper.PersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : lijianwen
 * @Date : 2020-05-15
 * @Version : 1.0
 */
@Service
public class PersionService {

    @Autowired(required = false)
    private PersionMapper persionMapper;

    public List<PersionDto> queryPersionList(){
        List<PersionDto> list = persionMapper.queryPersionList();
        return list;
    }
}
