package cn.mty.jts.jtsoa.dao;

import cn.mty.jts.jtsoa.pojo.Rewardandpunishment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RewardAndPunishmentMapper {

    @Insert("insert into rewardandpunishment(userid,bonus,balance,rptype,descstr,createtime) values(#{userId},#{bonus},#{balance},#{rptype},#{descStr},#{createTime})")
    public int insert(Rewardandpunishment rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 0")
    public List<Rewardandpunishment> getRewardsOfAll(Rewardandpunishment rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 1")
    public List<Rewardandpunishment> getPunishmentOfAll(Rewardandpunishment rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 2")
    public List<Rewardandpunishment> getRewardsOfAdd(Rewardandpunishment rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 0 and userid = #{userId}")
    public List<Rewardandpunishment> getRewardsOfUser(Rewardandpunishment rewardAndPunishment);

    @Select("select * from rewardandpunishment where rptype = 1 and userid = #{userId}")
    public List<Rewardandpunishment> getPunishmentOfUser(Rewardandpunishment rewardAndPunishment);


}
