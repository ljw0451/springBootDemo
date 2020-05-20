package com.ljw.controller;

import com.ljw.entity.PersionDto;
import com.ljw.service.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author : lijianwen
 * @Date : 2020-05-15
 * @Version : 1.0
 */
@Controller
public class PersionTestController {

    @Autowired
    private PersionService persionService;

    @RequestMapping("/queryPersion")
    @ResponseBody
    public List queryPersion(){
        List<PersionDto> list = persionService.queryPersionList();
        return list;
    }

    @RequestMapping("/testljw")
    public String aa(){

        return "login";
    }
}
