package com.czp.controller;

import com.czp.pojo.Address;
import com.czp.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/HelloHandler")
public class HelloHandler {

    /**
     * 当客户端访问index请求时
     * 直接自动关联到这个方法
     * 执行这个方法后，会返回结果
     * @ return
     */

    // RequestParam引入参数
    @RequestMapping(value = "/hello")
    public String index(@RequestParam("name") String userName,
                        @RequestParam("gender") String userGender){
        System.out.println(userGender + userName + "接收到了hello请求");
        //返回逻辑视图 逻辑视图相当于视图的别名 通过这个找到物理视图，也就是真正的视图
        //这里返回的只是页面的名称，不是完整的页面访问路径
        return "hello";
    }

    // cookie
    @RequestMapping("/textTask")
    public String textTask(@CookieValue("JSESSIONID") String cookie){
        System.out.println("textTask打开成功了, 下面是cookie信息:");
        System.out.println(cookie);
        return "textTask";
    }

    // POJO_01  User01
    @RequestMapping("/user")
    public String user01(){
        return "addUser";
    }

    // POJO_02 addUser-01
    @RequestMapping("/add01")
    public String add01(User user){
        System.out.println(user);
        return "index";
    }
    
    // 数据绑定
    @RequestMapping("/data")
    @ResponseBody
    public String data(String str){
        return "str="+str;
    }

    // MVC视图解析  addUser-02  将视图index和数据user绑定
    @RequestMapping("/add02")
    public ModelAndView add02(User user){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("myUser",user);
        return mv;
    }

    // Servlet   addUser-03   获取数据user,返回视图index
    @RequestMapping("/add03")
    public String add03(HttpServletRequest request, User user){
        request.setAttribute("myUser", user);
        return "index";
    }

    // ModelAttribute user02
    @ModelAttribute
    public User user02(){
        User user = new User();
        user.setName("张三");
        user.setID(106);
        Address address = new Address(1234, "桂林");
        user.setAddress(address);
        return user;
    }

    // Session   addUser-04   获取数据user,返回视图index
    @RequestMapping("/add04")
    public String add04(HttpSession session, User user){
        session.setAttribute("myUser", user);
        return "index";
    }
}
