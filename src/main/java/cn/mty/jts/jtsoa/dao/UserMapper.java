package cn.mty.jts.jtsoa.dao;

import cn.mty.jts.jtsoa.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
   public int save(User user);

   public User get(int id);

   @Select("select * from user")
   public List<User> getAll();

   @Delete("delete from user where id = #{id}")
   public int delUser(int id);


   @Select("select * from user where username = #{userName} and password = #{password}")
   public User getUserByUP(User user);

}
