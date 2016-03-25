package com.ycy.controller;

import com.ycy.model.UserAccount;
import com.ycy.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/8/15 0015.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Userservice userService;
    @ResponseBody
    @RequestMapping("/getuser/{id}")
    public UserAccount getUserByUserId(@PathVariable String id, HttpServletRequest request ){
        UserAccount u = userService.getUserAccountById(new Long(id));
        request.setAttribute("user", u);
        return u;
    }
    
    @RequestMapping("/index")
    public String index() {
    	System.out.println("Test-----------");
    	return "test";
    }
}
