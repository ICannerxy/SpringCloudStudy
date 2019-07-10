package com.study.auth.server.service;

import com.study.auth.server.dataobject.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author XuYang
 * @description:
 * @date 2019/7/10  11:40
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
