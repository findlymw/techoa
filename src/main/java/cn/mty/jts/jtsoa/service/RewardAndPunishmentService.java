package cn.mty.jts.jtsoa.service;

import cn.mty.jts.jtsoa.dao.RewardAndPunishmentMapper;

import java.util.List;

public interface RewardAndPunishmentService {

    public int insert(RewardAndPunishmentMapper rewardAndPunishment) throws Exception;

    public List<RewardAndPunishmentMapper> getRewardsOfAll(RewardAndPunishmentMapper rewardAndPunishment) throws Exception;

    public List<RewardAndPunishmentMapper> getPunishmentOfAll(RewardAndPunishmentMapper rewardAndPunishment) throws Exception;

    public List<RewardAndPunishmentMapper> getRewardsOfAdd(RewardAndPunishmentMapper rewardAndPunishment) throws Exception;

    public List<RewardAndPunishmentMapper> getRewardsOfUser(RewardAndPunishmentMapper rewardAndPunishment) throws Exception;

    public List<RewardAndPunishmentMapper> getPunishmentOfUser(RewardAndPunishmentMapper rewardAndPunishment) throws Exception;
}
