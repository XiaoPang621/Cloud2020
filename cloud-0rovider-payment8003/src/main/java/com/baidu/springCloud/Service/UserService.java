package com.baidu.springCloud.Service;

import com.baidu.cloud.Entitys.User;

import java.util.List;

/**
 * 用户服务类
 */
public interface UserService {
    List<User> findbypage();
}
