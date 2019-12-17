package com.wayne.frame.dao;

import com.wayne.frame.base.SuperMapper;
import com.wayne.frame.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author xzhang
 * @date 2019-12-11 12:46
 **/

@Mapper
@Repository
public interface UserMapper extends SuperMapper<UserEntity> {
    List<UserEntity> findByUserName(String name);

    UserEntity findUserAddrByName(String name);
}
