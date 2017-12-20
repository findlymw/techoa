package cn.mty.jts.jtsoa.controller.user;

import cn.mty.jts.jtsoa.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "welcome";
    }

}
