package com.example.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.dao.UserDOMapper;
import com.example.dataObject.UserDO;
import com.example.service.UserService;
import com.example.service.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/mybatis")
public class MybatisController {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String testMybatis(){
        UserDO insertDO = new UserDO();
        insertDO.setName("jiezhigang");
        insertDO.setAge(12);
        insertDO.setGender(true);
        insertDO.setRegisterMode("as");
        insertDO.setTelphone("adafda");
        insertDO.setThirdPartyId("asdas");

        int result = userDOMapper.insertSelective(insertDO);
        return "find record "+ result;
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public UserInfoModel getUserInfo(@RequestParam(name = "id") Integer id){

        return userService.getUserInfo(1);
    }

}
