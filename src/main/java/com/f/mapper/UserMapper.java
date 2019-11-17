package com.f.mapper;
import java.time.Instant;

import com.f.domain.User;import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectByAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int updateUsernameById(@Param("updatedUsername") String updatedUsername, @Param("id") Long id);

    int updateUsernameByPassword(@Param("updatedUsername") String updatedUsername, @Param("password") String password);
}