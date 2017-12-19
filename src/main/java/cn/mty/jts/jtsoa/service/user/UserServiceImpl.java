package cn.mty.jts.jtsoa.service.user;

import cn.mty.jts.jtsoa.dao.user.UserMapper;
import cn.mty.jts.jtsoa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }
}
