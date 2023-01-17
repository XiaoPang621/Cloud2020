package com.baidu.cloud.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
* @description : 用户类
* @author : WangYaFei
* @date: 2022/8/19 16:12
*/
public class User implements Serializable {
    private String username;
    private String password;
}