package com.wayne.frame.service;

import com.baomidou.mybatisplus.service.IService;
import com.zx.springboottest.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzhang
 * @date 2019-12-11 13:13
 **/
@Service
public interface UserService extends IService<UserEntity> {
    List<UserEntity> findByUserName(String name);

    void findUserAddrByName(String name);

}
