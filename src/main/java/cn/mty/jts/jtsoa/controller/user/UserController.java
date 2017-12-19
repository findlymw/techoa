package cn.mty.jts.jtsoa.controller.user;

import cn.mty.jts.jtsoa.pojo.User;
import cn.mty.jts.jtsoa.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index.html")
    public String index(){
       User user = userService.get(1);
        return "aaa + " + user.getNickName();
    }

}
