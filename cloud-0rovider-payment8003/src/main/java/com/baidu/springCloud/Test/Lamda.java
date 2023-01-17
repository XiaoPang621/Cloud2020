package com.baidu.springCloud.Test;

import com.baidu.springCloud.entity.User;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Description : Lamda
 * @Author : WangYaFei
 * @Date: 2022-05-30 14:16
 */
public class Lamda {
    public static void test1(){
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> set=new TreeSet<Integer>(com);
        set.add(1);
        set.add(2);
        System.out.println(set);
    }
    public static void test2(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        TreeSet<Integer> set=new TreeSet<Integer>(com);
        set.add(1);
        set.add(2);
        System.out.println(set);
    }

     static List<User> user= Arrays.asList(
         new User("1","1232312"),
             new User("2","1232312"),
             new User("3","1232312"),
             new User("4","1232312")
     );

    public static void main(String[] args) {
        String str="202209006804";
        System.out.println(str.substring(2,str.length()));
       /* user.stream().filter((e)->3>2).forEach(System.out::println);*/

       //String sc= doubleToThousands(123456.32232332);

        Thread.interrupted();
    }
    public static String doubleToThousands(Double doubleValue){
        if(null==doubleValue) return "";
        String str;
        StringBuffer sb=new StringBuffer(new DecimalFormat("##0.00#####").format(Double.parseDouble(new BigDecimal(doubleValue).toString())));
        for (int i = sb.indexOf("."); i > 3; i-=3) {
            sb.insert(i-3, ",");
        }
        str=sb.toString().replace("-,","-");
        return str;
    }

}
