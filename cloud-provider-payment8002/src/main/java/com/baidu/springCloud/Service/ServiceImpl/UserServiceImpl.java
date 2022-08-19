package com.baidu.springCloud.Service.ServiceImpl;

import com.baidu.cloud.Entitys.User;
import com.baidu.springCloud.Mapper.UserMapper;
import com.baidu.springCloud.Service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findbypage() {
        User user=new User();
        Wrapper<User> wrapper=new QueryWrapper<>();
        return userMapper.selectList(wrapper);
    }
}
