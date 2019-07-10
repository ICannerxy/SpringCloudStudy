package com.study.auth.server.service.impl;

import com.study.auth.server.dataobject.UserInfo;
import com.study.auth.server.repository.UserInfoRepository;
import com.study.auth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XuYang
 * @description:
 * @date 2019/7/10  11:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
