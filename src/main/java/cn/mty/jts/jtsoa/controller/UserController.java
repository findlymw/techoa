package cn.mty.jts.jtsoa.controller;

import cn.mty.jts.jtsoa.pojo.User;
import cn.mty.jts.jtsoa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "aaa";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }

    @RequestMapping("/user/index.html")
    public String welcomeUser(Map<String, Object> model) {
        model.put("message", this.message);
        return "userindex";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,User user){

        System.out.println("username:" + user.getUserName());
        System.out.println("password:" + user.getPassword());

        User _user = null;
        try {
            _user = userService.getUserByUP(user);
        } catch (Exception e) {
            _user = null;
        }

        if(null != _user){
            System.out.println("login : " + _user.getUserName());
            return "redirect:/user/index.html";
        }

        return "redirect:/";
    }

}
