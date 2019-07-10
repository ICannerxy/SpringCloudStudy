package com.study.auth.server.controller;

import com.study.auth.server.VO.ResultVO;
import com.study.auth.server.constant.CookieConstant;
import com.study.auth.server.constant.RedisConstant;
import com.study.auth.server.dataobject.UserInfo;
import com.study.auth.server.enums.ResultEnum;
import com.study.auth.server.enums.RoleEnum;
import com.study.auth.server.service.UserService;
import com.study.auth.server.utils.CookieUtil;
import com.study.auth.server.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYang
 * @description:
 * @date 2019/7/10  12:15
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 买家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
        // openid和数据库进行匹配
        UserInfo user = userService.findByOpenid(openid);

        if (null == user) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        if (RoleEnum.BUYER.getCode() != user.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 设置cookie
        CookieUtil.setCookie(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response, HttpServletRequest request) {
        // openid和数据库进行匹配
        UserInfo user = userService.findByOpenid(openid);

        // 已登录直接返回
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (null != cookie &&
                !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }
        if (null == user) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        if (RoleEnum.SELLER.getCode() != user.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 数据写入Redis key
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        Integer expire = CookieConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);

        // 设置cookie
        CookieUtil.setCookie(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }
}
