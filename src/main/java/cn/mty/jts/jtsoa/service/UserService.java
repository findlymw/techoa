package cn.mty.jts.jtsoa.service;

import cn.mty.jts.jtsoa.pojo.User;

public interface UserService {

    public  int save(User user) throws Exception;
    public User get(int id) throws Exception;
    public User getUserByUP(User user) throws Exception;
}
