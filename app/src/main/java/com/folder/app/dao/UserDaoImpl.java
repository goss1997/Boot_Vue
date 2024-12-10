package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.UserDTO;
import com.folder.app.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int editById(UserDTO uDto) {
        return userMapper.editById(uDto);
    }

    @Override
    public int delete(int no) {
        return userMapper.delete(no);
    }

    @Override
    public int save(UserDTO uDto) {
        return userMapper.save(uDto);
    }

    @Override
    public UserDTO findById(int no) {
        return userMapper.findById(no);
    }

}
