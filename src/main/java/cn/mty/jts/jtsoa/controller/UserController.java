package cn.mty.jts.jtsoa.controller;

import cn.mty.jts.jtsoa.common.CommonUtil;
import cn.mty.jts.jtsoa.common.MD5;
import cn.mty.jts.jtsoa.dao.RewardAndPunishmentMapper;
import cn.mty.jts.jtsoa.pojo.ExecutePOJO;
import cn.mty.jts.jtsoa.pojo.Rewardandpunishment;
import cn.mty.jts.jtsoa.pojo.TotalAccount;
import cn.mty.jts.jtsoa.pojo.User;
import cn.mty.jts.jtsoa.service.RewardAndPunishmentService;
import cn.mty.jts.jtsoa.service.TotalAccountService;
import cn.mty.jts.jtsoa.service.UserService;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TotalAccountService totalAccountService;

    @Autowired
    private RewardAndPunishmentService rewardAndPunishmentService;

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
    public String addUser(HttpServletRequest request,User user){
        User suser = (User) request.getSession().getAttribute("user");
        if(null != suser && suser.getAdmin() == 777) {
            if (null != user && !StringUtils.isEmpty(user.getUserName())) {
                user.setPassword(MD5.parseStrToMd5U32("123456"));
                user.setAdmin(0);
                user.setNickName(user.getUserName());
                user.setCreateTime(System.currentTimeMillis());
                try {
                    userService.save(user);
                } catch (Exception e) {

                }
            }
        }
        return "redirect:/user/manage/index.html";
    }

    @RequestMapping(value = "/user/delUser/{id}.html",method = RequestMethod.GET)
    public String delUser(HttpServletRequest request,@PathVariable int id){
        User suser = (User) request.getSession().getAttribute("user");
        if(null != suser && suser.getAdmin() == 777) {
            if (0 < id) {
                try {
                    userService.delUser(id);
                } catch (Exception e) {

                }
            }
        }
        return "redirect:/user/manage/index.html";
    }

    @RequestMapping(value = "/user/execute.html",method = RequestMethod.POST)
    public String execute(HttpServletRequest request,ExecutePOJO executePOJO){
        User suser = (User) request.getSession().getAttribute("user");
        if(null != suser && suser.getAdmin() == 777) {
            if(null != executePOJO && executePOJO.getUserId() > 0 && executePOJO.getAmount() > 0){

                long totalAcount = 0;
                try {
                    totalAcount = totalAccountService.getTotalAccount();
                } catch (Exception e) {
                    totalAcount = 0;
                }

                Rewardandpunishment rewardandpunishment = null;
                if(totalAcount > 0) {
                    rewardandpunishment = new Rewardandpunishment();
                    rewardandpunishment.setUserId(executePOJO.getUserId());
                    rewardandpunishment.setBonus(executePOJO.getAmount());
                    rewardandpunishment.setCreateTime(System.currentTimeMillis());
                    if (executePOJO.getOpType() == 1) {
                        rewardandpunishment.setRptype(0);
                        rewardandpunishment.setDescStr(
                                executePOJO.getUserName() + "于" +
                                CommonUtil.timeFormat(System.currentTimeMillis())+
                                "获得" + CommonUtil.getPriceFormat(executePOJO.getAmount()) + "元的奖励资金.");
                        BigDecimal totalBD = new BigDecimal(totalAcount);
                        BigDecimal balance = totalBD.subtract(new BigDecimal(executePOJO.getAmount()));
                        rewardandpunishment.setBalance(balance.longValue());
                    } else if (executePOJO.getOpType() == 2) {
                        rewardandpunishment.setRptype(1);
                        rewardandpunishment.setDescStr(executePOJO.getUserName() + "于" +
                                CommonUtil.timeFormat(System.currentTimeMillis())+
                                "获得" +  CommonUtil.getPriceFormat(executePOJO.getAmount()) + "元的惩罚资金.");
                        BigDecimal totalBD = new BigDecimal(totalAcount);
                        BigDecimal balance = totalBD.add(new BigDecimal(executePOJO.getAmount()));
                        rewardandpunishment.setBalance(balance.longValue());
                    }

                    try {
                        rewardAndPunishmentService.insert(rewardandpunishment);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


                System.out.println(JSONArray.toJSONString(executePOJO));
            }
        }
        return "redirect:/user/manage/index.html";
    }

}
