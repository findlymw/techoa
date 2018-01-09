package cn.mty.jts.jtsoa.dao;

import cn.mty.jts.jtsoa.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password,nickname,admin,createtime) values(#{userName},#{password},#{nickName},#{admin},#{createTime})")
   public int save(User user);

   public User get(int id);

   @Select("select * from user where admin = 0")
   public List<User> getAll();

   @Delete("delete from user where id = #{id}")
   public int delUser(int id);


   @Select("select * from user where username = #{userName} and password = #{password}")
   public User getUserByUP(User user);

   @Update("update user set password = #{password} where id = #{id}")
   public int updatePasswordByUserId(User user);

}
