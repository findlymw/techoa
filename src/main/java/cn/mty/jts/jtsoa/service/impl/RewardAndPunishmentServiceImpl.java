package cn.mty.jts.jtsoa.service.impl;

import cn.mty.jts.jtsoa.dao.RewardAndPunishmentMapper;
import cn.mty.jts.jtsoa.dao.TotalAccountMapper;
import cn.mty.jts.jtsoa.pojo.Rewardandpunishment;
import cn.mty.jts.jtsoa.pojo.TotalAccount;
import cn.mty.jts.jtsoa.service.RewardAndPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.ExportException;
import java.util.List;

@Service
public class RewardAndPunishmentServiceImpl implements RewardAndPunishmentService {

    @Autowired
    private RewardAndPunishmentMapper rewardAndPunishmentMapper;
    @Autowired
    private TotalAccountMapper totalAccountMapper;

    @Transactional
    @Override
    public int insert(Rewardandpunishment rewardAndPunishment) throws Exception{
        TotalAccount totalAccount = new TotalAccount();
        totalAccount.setAccount(rewardAndPunishment.getBalance());
        totalAccountMapper.updateTotalAccount(totalAccount);
        return rewardAndPunishmentMapper.insert(rewardAndPunishment);
    }

    @Override
    public List<Rewardandpunishment> getRewardsOfAll(Rewardandpunishment rewardAndPunishment)  throws Exception{
        return rewardAndPunishmentMapper.getRewardsOfAll(rewardAndPunishment);
    }

    @Override
    public List<Rewardandpunishment> getPunishmentOfAll(Rewardandpunishment rewardAndPunishment)  throws Exception{
        return rewardAndPunishmentMapper.getPunishmentOfAll(rewardAndPunishment);
    }

    @Override
    public List<Rewardandpunishment> getRewardsOfAdd(Rewardandpunishment rewardAndPunishment) throws Exception {
        return rewardAndPunishmentMapper.getRewardsOfAdd(rewardAndPunishment);
    }

    @Override
    public List<Rewardandpunishment> getRewardsOfUser(Rewardandpunishment rewardAndPunishment) throws Exception {
        return rewardAndPunishmentMapper.getRewardsOfUser(rewardAndPunishment);
    }

    @Override
    public List<Rewardandpunishment> getPunishmentOfUser(Rewardandpunishment rewardAndPunishment)  throws Exception{
        return rewardAndPunishmentMapper.getPunishmentOfUser(rewardAndPunishment);
    }
}
