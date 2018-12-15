package com.example.service;

import com.example.service.model.UserInfoModel;
import org.springframework.stereotype.Service;

public interface UserService {

    UserInfoModel getUserInfo(Integer id);
}
