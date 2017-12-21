package cn.mty.jts.jtsoa.service;

import cn.mty.jts.jtsoa.pojo.User;

import java.util.List;

public interface UserService {

    public  int save(User user) throws Exception;
    public User get(int id) throws Exception;
    public User getUserByUP(User user) throws Exception;
    public List<User> getAll() throws Exception;
    public int delUser(int id) throws Exception;
}
