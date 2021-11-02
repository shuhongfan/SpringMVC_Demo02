package com.shf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {
//@RequestMapping注解的value属性通过请求的请求地址匹配请求映射
//@RequestMapping注解的method属性通过请求的请求方式
//@RequestMapping注解的params属性通过请求的请求参数匹配请求映射
    @RequestMapping(
            value = {"/testRequestMapping","/test"},
            method = {RequestMethod.GET}
    )
    public String succrss(){
        return "success";
    }

    @GetMapping("/testGetMapping")
    public  String testGetMapping(){
        return "success";
    }

    @PostMapping("/testPostMapping")
    public  String testPostMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

//    params的条件必须同时满足
    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123456"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }

//    SpringMVC支持ant风格的路径
//    ?任意当单个字符  * 0个或多个  ** 任意层目录
//    @RequestMapping("/a?a/testAnt")
//    @RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "success";
    }
//    @RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
//    在通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
        System.out.println("id:"+id);
        System.out.println("username:"+username);
        return "success";
    }
}
