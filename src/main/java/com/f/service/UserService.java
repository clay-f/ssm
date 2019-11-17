package com.f.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.f.domain.User;
import com.f.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 在事物里面，直接调用
     */
    @Transactional
    public void  insertDirectly(User user) {
        insert(user);
    }

    /**
     *  使用 userMapper 间接调用
     * @param use
     */
    @Transactional
    public void insertWithUserMapper(User use) {
        userMapper.insert(use);
    }


    public int insert(User record) {
        return userMapper.insert(record);
    }


    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }


    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll(RowBounds row) {
        return userMapper.selectByAll();
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
