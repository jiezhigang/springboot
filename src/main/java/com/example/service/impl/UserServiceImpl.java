package com.example.service.impl;

import com.example.dao.UserDOMapper;
import com.example.dataObject.UserDO;
import com.example.service.UserService;
import com.example.service.model.UserInfoModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserInfoModel getUserInfo(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        UserInfoModel userInfoModel = new UserInfoModel();
        BeanUtils.copyProperties(userDO, userInfoModel);
        return userInfoModel;
    }
}
