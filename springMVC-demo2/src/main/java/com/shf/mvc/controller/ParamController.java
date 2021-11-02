package com.shf.mvc.controller;

import com.shf.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {
//    通过ServletAPI获取
    @RequestMapping("/testServletAPI")
//    形参位置的request表示当前请求
    public String testServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("usernae="+username);
        System.out.println("password="+password);
        System.out.println("session="+session);
        return "success";
    }

//    通过控制器方法的形参获取请求参数
    @RequestMapping("/testParam")
    public String testParam(
//            @RequestParam是将请求参数和控制器方法的形参创建映射关系
//            required：设置是否必须传输此请求参数，默认值为true
//            defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值
            @RequestParam(value = "user_name",required = false,defaultValue = "root") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "host",required = true,defaultValue = "80") String Host,
            @CookieValue("JSESSIONID") String JSESSIONID
    ){
//        多请求参数中出现多个同名的请求参数,可以在控制器方法的形参位置设置字符串类型或字符串数组接收请求参数
//        若使用字符串的形参,最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("hobby="+ Arrays.toString(hobby));
        System.out.println("Host="+ Host);
        System.out.println("JSESSIONID="+ JSESSIONID);
        return "success";
    }

//    通过POJO获取请求参数
    @RequestMapping("/testPOJO")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
