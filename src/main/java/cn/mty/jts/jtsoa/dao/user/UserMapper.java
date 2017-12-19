package cn.mty.jts.jtsoa.dao.user;

import cn.mty.jts.jtsoa.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
   public int save(User user);

   public User get(int id);
}
