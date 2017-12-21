package cn.mty.jts.jtsoa.service.impl;

import cn.mty.jts.jtsoa.dao.RewardAndPunishmentMapper;
import cn.mty.jts.jtsoa.service.RewardAndPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RewardAndPunishmentServiceImpl implements RewardAndPunishmentService {

    @Autowired
    private RewardAndPunishmentMapper rewardAndPunishmentMapper;
    @Transactional
    @Override
    public int insert(RewardAndPunishmentMapper rewardAndPunishment) {
        return rewardAndPunishmentMapper.insert(rewardAndPunishment);
    }

    @Override
    public List<RewardAndPunishmentMapper> getRewardsOfAll(RewardAndPunishmentMapper rewardAndPunishment)  throws Exception{
        return rewardAndPunishmentMapper.getRewardsOfAll(rewardAndPunishment);
    }

    @Override
    public List<RewardAndPunishmentMapper> getPunishmentOfAll(RewardAndPunishmentMapper rewardAndPunishment)  throws Exception{
        return rewardAndPunishmentMapper.getPunishmentOfAll(rewardAndPunishment);
    }

    @Override
    public List<RewardAndPunishmentMapper> getRewardsOfAdd(RewardAndPunishmentMapper rewardAndPunishment) throws Exception {
        return rewardAndPunishmentMapper.getRewardsOfAdd(rewardAndPunishment);
    }

    @Override
    public List<RewardAndPunishmentMapper> getRewardsOfUser(RewardAndPunishmentMapper rewardAndPunishment) throws Exception {
        return rewardAndPunishmentMapper.getRewardsOfUser(rewardAndPunishment);
    }

    @Override
    public List<RewardAndPunishmentMapper> getPunishmentOfUser(RewardAndPunishmentMapper rewardAndPunishment)  throws Exception{
        return rewardAndPunishmentMapper.getPunishmentOfUser(rewardAndPunishment);
    }
}
