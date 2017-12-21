package cn.mty.jts.jtsoa.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TotalAccountMapper {

    @Update("update totalaccount set account = #{account} where id = 1")
    public int updateTotalAccount(TotalAccountMapper totalAccount);

    @Select("select account from totalaccount where id = 1")
    public long getTotalAccount();

}
