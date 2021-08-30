package com.atcafuc.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;


/**
 * jdk8中日期时间API测试
 * @author jh
 * @create 2021-08-17 15:37
 */
public class JDK8DateTimeTest {
    @Test
    public void test() {
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1.toString());

    }

    /*
        LocalDate、LocalTime、LocalDateTime
        1.LocalDateTime 用的频率较高
        2.类似于Calendar
     */
    @Test
    public void test1() {
        //now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of(): 设置指定的年、月、日、时、分、秒。没有偏移量
//        LocalDateTime.of(2020,10,6,13,30,15);
        LocalDateTime  localDateTime1 = LocalDateTime.of(2020,10,6,13,30,15);
        System.out.println(localDateTime1);

        //getXX()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfWeek());

        //modify: 体现不可变性、有返回值
        //with(): 设置相关属性
        localDateTime1 = localDateTime.withDayOfMonth(20);
        System.out.println(localDateTime1 .getDayOfMonth());

        //
        LocalDateTime localDateTime2 = localDateTime1.plusDays(3);
        System.out.println(localDateTime2);
    }

    /*
    Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void instantTest() {
        Instant instant = Instant.now(); //格林威治时间 本初子午线
        System.out.println(instant);

        //添加时区偏移量
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8))); //东八区时间    }

        // toEpochMilli(): 获取1970-01-01 0:0:0(UTC)开始的毫秒数   -----> Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli(): 造Instant对象 通过给定毫秒数，获取Instant实例  ---->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1629188519618L);
    }



    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
//         预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME

        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化:  日期 ----》字符串
        String str1 = isoLocalDateTime.format(LocalDateTime.now());
        System.out.println(isoLocalDateTime);
        System.out.println(str1);

        // 字符串 ---》 日期
        TemporalAccessor parse = isoLocalDateTime.parse("2021-08-17T16:41:23.879");
        System.out.println(parse);

//         本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)

//         自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)  主要掌握!!!!!!!!!!
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //格式化
        String str2 = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(str2);

        //解析
        TemporalAccessor parse1 = dateTimeFormatter.parse("2021-08-17 05:08:59");
        System.out.println(parse1);
    }




}