package com.baidu.springCloud.Test;

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.baidu.springCloud.entity.EasyExcelUtil;
import com.baidu.springCloud.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * @Description : EasyExcelCreateFile
 * @Author : WangYaFei
 * @Date: 2022-07-12 09:56
 */
public class EasyExcelCreateFile {
    @Autowired
    private EasyExcelUtil excelUtil;
    @Test
    public void exportRightsSale(HttpServletResponse resp, List<User> list) {
        try {
            List<User> userList=new ArrayList<>();
            User user=new User();
            for (int i = 0; i <1000 ; i++) {
                user.setUsername("账号："+i);
                user.setPassword("密码："+i);
                userList.add(user);
            }
            //使用工具类EasyExcelUtil写数据，第三个参数是导出后文件名称，最后一个参数指定写用哪个class去写
            excelUtil.writeExcel(resp, userList, "file", "sheet1", User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {

        HttpServletResponse response=new HttpServletResponse();
        exportRightsSale(response,userList);
    }*/
}
