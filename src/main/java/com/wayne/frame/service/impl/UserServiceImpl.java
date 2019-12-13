package com.wayne.frame.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zx.springboottest.dao.UserMapper;
import com.zx.springboottest.entity.UserEntity;
import com.zx.springboottest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzhang
 * @date 2019-12-11 13:13
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findByUserName(String name) {

        List<UserEntity> list = userMapper.findByUserName(name);
        if (list != null) {
            for (UserEntity user : list) {
                System.out.println(user.getUserName());
            }
        }
        return list;
    }

    @Override
    public void findUserAddrByName(String name) {

    }


}
