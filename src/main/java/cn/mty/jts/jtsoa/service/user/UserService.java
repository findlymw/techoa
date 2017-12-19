package cn.mty.jts.jtsoa.service.user;

import cn.mty.jts.jtsoa.pojo.User;

public interface UserService {

    public  int save(User user);

    public User get(int id);
}
