package cn.mty.jts.jtsoa.controller;

import cn.mty.jts.jtsoa.common.CommonUtil;
import cn.mty.jts.jtsoa.common.MD5;
import cn.mty.jts.jtsoa.pojo.TotalAccount;
import cn.mty.jts.jtsoa.pojo.User;
import cn.mty.jts.jtsoa.service.TotalAccountService;
import cn.mty.jts.jtsoa.service.UserService;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TotalAccountService totalAccountService;

    // inject via application.properties
    //@Value("${welcome.message:test}")
    //private String message = "aaa";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping("/user/index.html")
    public String welcomeUser(HttpServletRequest request,Map<String, Object> model) {
        model.put("user", (User)request.getSession().getAttribute("user"));
        long account = 0;
        try{
            account = totalAccountService.getTotalAccount();
        }catch(Exception e){
            account = 0;
        }
        model.put("totalAccount", CommonUtil.getPriceFormat(account));
        return "userindex";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,User user){

        if(null != user && null != user.getUserName() && null != user.getPassword()){
            user.setPassword(MD5.parseStrToMd5U32(user.getPassword()));
            User _user = null;
            try {
                _user = userService.getUserByUP(user);
            } catch (Exception e) {
                _user = null;
            }

            if(null != _user){
                request.getSession().setAttribute("user",_user);
                return "redirect:/user/index.html";
            }
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }


    @RequestMapping(value = "/user/manage/index.html",method = RequestMethod.GET)
    public String userManage(HttpServletRequest request,Map<String, Object> model){
        User user = (User) request.getSession().getAttribute("user");

        if(null != user && user.getAdmin() == 777){
            List<User> userList = null;
            try {
                userList = userService.getAll();
            } catch (Exception e) {
                userList = null;
            }

            model.put("userList",userList);
            return "usermanage";
        }

        return "redirect:/user/index.html";
    }

    @RequestMapping(value = "/user/addUser.html",method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println("----" + user.getUserName());
        if(null != user && !StringUtils.isEmpty(user.getUserName())){
            user.setPassword(MD5.parseStrToMd5U32("123456"));
            user.setAdmin(0);
            user.setNickName(user.getUserName());
            user.setCreateTime(System.currentTimeMillis());
            try {
                userService.save(user);
            } catch (Exception e) {

            }
        }
        return "redirect:/user/manage/index.html";
    }

}
