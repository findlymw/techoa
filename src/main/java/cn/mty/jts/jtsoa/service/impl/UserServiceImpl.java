package cn.mty.jts.jtsoa.service.impl;

import cn.mty.jts.jtsoa.dao.UserMapper;
import cn.mty.jts.jtsoa.pojo.User;
import cn.mty.jts.jtsoa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public int save(User user) throws Exception {
        return userMapper.save(user);
    }

    @Override
    public User get(int id) throws Exception {
        return userMapper.get(id);
    }

    @Override
    public User getUserByUP(User user) throws Exception {
        return userMapper.getUserByUP(user);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userMapper.getAll();
    }

    @Override
    public int delUser(int id) throws Exception {
        return userMapper.delUser(id);
    }
}
