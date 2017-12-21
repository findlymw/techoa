package cn.mty.jts.jtsoa.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RewardAndPunishmentMapper {

    @Insert("insert into rewardandpunishment(userid,bonus,balance,rptype,createtime) values(#{userId},#{bonus},#{balance},#{rptype},#{createTime})")
    public int insert(RewardAndPunishmentMapper rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 0")
    public List<RewardAndPunishmentMapper> getRewardsOfAll(RewardAndPunishmentMapper rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 1")
    public List<RewardAndPunishmentMapper> getPunishmentOfAll(RewardAndPunishmentMapper rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 2")
    public List<RewardAndPunishmentMapper> getRewardsOfAdd(RewardAndPunishmentMapper rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 0 and userid = #{userId}")
    public List<RewardAndPunishmentMapper> getRewardsOfUser(RewardAndPunishmentMapper rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 1 and userid = #{userId}")
    public List<RewardAndPunishmentMapper> getPunishmentOfUser(RewardAndPunishmentMapper rewardAndPunishment);


}
