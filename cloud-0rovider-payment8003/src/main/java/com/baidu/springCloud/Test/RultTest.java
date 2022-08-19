package com.baidu.springCloud.Test;

import com.baidu.springCloud.entity.CsvUtil;
import com.baidu.springCloud.entity.User;
import com.netflix.discovery.DiscoveryClient;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.csv.CSVRecord;
import org.springframework.cloud.client.ServiceInstance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description : RultTest
 * @Author : WangYaFei
 * @Date: 2022-05-06 15:58
 */
public class RultTest {

    private static String downLoadName;
    private static InputStream fis;

    public static byte[] exportCsv() {
        byte[] content = null;
        try {
            String[] sTitles = new String[]{"名称","年龄","性别"};
            String[] mapKeys = new String[]{"name","age","sex"};
            List<Map> dataList = new ArrayList<>();
            //数据
            for (int i = 0; i < 10; i++) {
                User user = new User("小明" + i, i, "男" + i);
                user.setUsername("21312312");
                user.setPassword("xiaoming");
                Map map = BeanUtils.describe(user);
                dataList.add(map);
            }

            ByteArrayOutputStream os = CsvUtil.doExport(sTitles,mapKeys,dataList);
            content = os.toByteArray();
            fis = new ByteArrayInputStream(content, 0, content.length);
            fis.close();
            downLoadName = new String("投资事项收款.csv".getBytes("gb2312"), "iso8859-1");
            System.out.println("文件名称："+downLoadName);
        }catch (Exception e){
            e.printStackTrace();
        }

        return content;
    }

    public static void main(String[] args) {
        exportCsv();
    }
}
