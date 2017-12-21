package cn.mty.jts.jtsoa.service;

import cn.mty.jts.jtsoa.dao.RewardAndPunishmentMapper;
import cn.mty.jts.jtsoa.pojo.Rewardandpunishment;

import java.util.List;

public interface RewardAndPunishmentService {

    public int insert(Rewardandpunishment rewardAndPunishment) throws Exception;

    public List<Rewardandpunishment> getRewardsOfAll(Rewardandpunishment rewardAndPunishment) throws Exception;

    public List<Rewardandpunishment> getPunishmentOfAll(Rewardandpunishment rewardAndPunishment) throws Exception;

    public List<Rewardandpunishment> getRewardsOfAdd(Rewardandpunishment rewardAndPunishment) throws Exception;

    public List<Rewardandpunishment> getRewardsOfUser(Rewardandpunishment rewardAndPunishment) throws Exception;

    public List<Rewardandpunishment> getPunishmentOfUser(Rewardandpunishment rewardAndPunishment) throws Exception;
}
