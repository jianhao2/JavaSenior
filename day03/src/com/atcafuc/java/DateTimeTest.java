package com.atcafuc.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK8.0 之前日期和时间的api测试
 * @author jh
 * @create 2021-08-13 14:43
 */
public class DateTimeTest
{
    // 1.System类中的 currentTimeMillis()方法  单位是：ms
    //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
    //称为时间戳
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = i; j < 10000; j++) {
                sum += j;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
        /*
        java.util.Date类
            |----java.sql.Date类
         1.两个构造器的使用
         2.两个方法的使用
             > toString(): 显示当前的年、月、日、时、分、秒
             > getTime():  获取当前对象对应的毫秒数时间戳
         3. java.sql.Date对应的数据库中的日期类型的变量
             > 如何实例化
             >如何将util.Date对象转化为sql.Date对象
         */
    @Test
    public void test2(){
        // 构造器1：Date()  ：创建一个当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        // 构造器2：
        Date date2 = new Date(1020838127371L);
        System.out.println(date2.toString());

        // 创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1628838127371L);
        System.out.println(date3.toString());

        //如何将java.util.Date对象转换为 java.sql.Date对象
//        // 情况一：
//        Date date4 = new java.sql.Date(1628838127371L);
//        java.sql.Date date5 = (java.sql.Date) date4;
//        System.out.println(date5.getClass());

        // 情况二：
          Date date6 = new Date();
          Date date7 = new Date(date6.getTime());
          System.out.println(date7.toString());



    }
}
