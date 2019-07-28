package com.weijiang.controller;

import com.weijiang.mapper.UserMapper;
import com.weijiang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Hello {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String Hellow(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("token".equals(cookie.getName())){
                String token = cookie.getValue();
                User user = userMapper.findByCookie(token);
                if(user != null){
                    request.getSession().setAttribute("user" , user);

                }
                System.out.println(user);
                break;
            }
        }

        return "hello";
    }
}
