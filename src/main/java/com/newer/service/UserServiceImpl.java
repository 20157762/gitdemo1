package com.newer.service;

import com.newer.domain.User;
import com.newer.Mapper.UserMapper;
import com.newer.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        password= MD5.getInstance().getMD5ofStr(password);
        return userMapper.findByParam(username,password);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public boolean register(User user) {
        if (userMapper.addUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkName(String username) {
        if (userMapper.findUsername(username)>0){
            return false;
        }
        return true;
    }

    @Override
    public User findById(int userId) {
        return userMapper.findById(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateUser(int userId,String password) {
        password=MD5.getInstance().getMD5ofStr(password);
        return userMapper.updateUser(userId,password);
    }
}
