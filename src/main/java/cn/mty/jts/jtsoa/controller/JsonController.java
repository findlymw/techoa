package cn.mty.jts.jtsoa.controller;

import cn.mty.jts.jtsoa.pojo.JsonObject;
import cn.mty.jts.jtsoa.pojo.Rewardandpunishment;
import cn.mty.jts.jtsoa.pojo.User;
import cn.mty.jts.jtsoa.service.RewardAndPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class JsonController {
    @Autowired
    private RewardAndPunishmentService rewardAndPunishmentService;

    @RequestMapping(value = "/user/rplist/{rpType}/{user}",method = RequestMethod.GET)
    public JsonObject rpList(HttpServletRequest request,
                             @PathVariable int rpType,
                             @PathVariable int user){

        User suser = (User) request.getSession().getAttribute("user");
        JsonObject jsonObject = new JsonObject();
        if(null != suser) {
            List<Rewardandpunishment> rewardandpunishments = null;
                try{
                    switch (rpType){
                        case 0 :
                            if(user > 0){
                                Rewardandpunishment rewardandpunishment = new Rewardandpunishment();
                                rewardandpunishment.setUserId(suser.getId());
                                rewardandpunishments = rewardAndPunishmentService.getRewardsOfUser(rewardandpunishment);
                            }else{
                                rewardandpunishments = rewardAndPunishmentService.getRewardsOfAll(new Rewardandpunishment());
                            }

                            break;
                        case 1 :
                            if(user > 0){
                                Rewardandpunishment rewardandpunishment = new Rewardandpunishment();
                                rewardandpunishment.setUserId(suser.getId());
                                rewardandpunishments = rewardAndPunishmentService.getPunishmentOfUser(new Rewardandpunishment());
                            }else {
                                rewardandpunishments = rewardAndPunishmentService.getPunishmentOfAll(new Rewardandpunishment());
                            }
                            break;
                        case 2 :
                                rewardandpunishments = rewardAndPunishmentService.getRewardsOfAdd(new Rewardandpunishment());
                            break;

                    }
                    jsonObject.setStatus(200);
                    jsonObject.setResult("true");
                    jsonObject.setMsg("success");
                    jsonObject.setDate(rewardandpunishments);
                    return jsonObject;
                }catch(Exception e){e.printStackTrace();}
            }

        jsonObject.setStatus(400);
        jsonObject.setResult("false");
        jsonObject.setMsg("get rp list failed.");
        return jsonObject;
    }
}
