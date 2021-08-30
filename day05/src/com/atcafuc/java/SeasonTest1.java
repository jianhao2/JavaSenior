package com.atcafuc.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于Java.lang.Enum类
 *
 * * 三、Enum类中的常用方法：
 *   values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *   valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。
 *                          如不是，会有运行时异常：IllegalArgumentException。
 *   toString()：返回当前枚举类对象常量的名称
 *
 *
 *
 * @author jh
 * @create 2021-08-20 11:29
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        //values()
    Season1[] season1 = Season1.values();
    for(int i=0;i<season1.length;i++){
        System.out.println(season1[i]);
        season1[i].show();
        }

    //valueOf(String str):
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}

interface Info{
   void show();
}


//使用enum关键字定义枚举类
enum Season1 implements Info{

    //1.提供当前枚举类的多个对象,多个对象之间用“，” ， 末尾的对象分号“; ”结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天夏天悄悄过去");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String  seasonName;
    private final String  seasonDesc;

    //3.私有化构造器,并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他述求1：获取枚举类对象的属性：
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    //5.其他述求2：提供toString()
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
