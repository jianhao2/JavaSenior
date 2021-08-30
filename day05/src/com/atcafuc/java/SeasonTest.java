package com.atcafuc.java;

/**
 * 一、枚举类：
 * 1.枚举类的对象只有有限个，确定的。我们称之为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.只有枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0 之前，自定义枚举类
 * 方式二： jdk5.0 之后，可以使用enum关键字1定义枚举类
 *

 *
 *  @author jh
 * @create 2021-08-20 11:05
 */

//自定义枚举类
public class SeasonTest {

}

class Season {
    //1.声明Season对象的属性:private final修饰
    private final String  seasonName;
    private final String  seasonDesc;

    //2.私有化构造器,并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象： public static final的
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    //4.其他述求1：获取枚举类对象的属性：
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //5.其他述求2：提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}