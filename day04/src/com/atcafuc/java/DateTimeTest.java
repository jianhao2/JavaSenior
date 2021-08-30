package com.atcafuc.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8 之前的的日期和时间测试
 * 1.system类中的currtentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author jh
 * @create 2021-08-17 11:33
 */
public class DateTimeTest {


    /*
       SimpleDateFormat的使用：SimpleDateFormat 对日期Date类的格式化和解析
       1. 两个操作：
           1.1 格式化：日期--->字符串
           1.2 解析： 格式化的逆过程，字符串---->日期

       2.SimpleDateFormat的实例化
        */
    @Test
    public void testSimpleDateFormat() throws ParseException {
//        SimpleDateFormat的实例化 : 使用默认的构造器  一般不用
        SimpleDateFormat sdf = new SimpleDateFormat();


        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

//        解析： 格式化的逆过程，字符串---->日期
        String str = "21-8-17 上午11:45";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //***************************调用带参的构造器*********************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf2.format(date);
        System.out.println(format1);

        //解析:要求字符串必须符合SimpleDateFormat识别的格式(通过构造器参数体现)，
        //否则抛异常
        Date date2 = sdf.parse(format);
        System.out.println(date2);
    }

    /*
    练习一：字符串“2020-02-08”转换为java.sql.Date

    练习二："三天打鱼两天晒网" 1990-01-01    xxxx-xx-xx 打鱼 or 晒网？
     */
    @Test
    public void test1() throws ParseException {
        String birth = "2020-02-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf1.parse(birth);
        java.sql.Date sqld = new java.sql.Date(date1.getTime());
        System.out.println(sqld);
        System.out.println(date1.getTime());
    }

    //    练习二："三天打鱼两天晒网" 1990-01-01    xxxx-xx-xx 打鱼 or 晒网？
    @Test
    public void test2() throws ParseException {
        String start = "1990-01-01";
        String end = "2020-09-08 ";
        String start1 = "1990-01-02";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        long day = sdf1.parse(start1).getTime() - sdf1.parse(start).getTime();
//        Date date = new Date(start);
        System.out.println(day);
        long days = sdf1.parse(end).getTime() / day;
        System.out.println(days);
        long x = days % 5;
        System.out.println(x);
    }


    /*
    Calendar 日历类(抽象类)的使用  //可变
     */
    @Test
    public void test3() {
        //1.实例化
        //方式一：创建其子类对象(Gregoriancalendar)的对象
        //方式二：调用其静态方法getInstance() 常用
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,20);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,5);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()  日历类--->Date类
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.getTime());



    }
}