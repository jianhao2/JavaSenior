package com.atcafuc.java;

import org.junit.Test;

/**
 * @author jh
 * @create 2021-08-11 15:31
 */
public class StringTest {

    /*
    String 字符串，"*"表示
    1.String声明为final的，不可被继承
    2.String 实现了Serializable接口： 表示字符串支持序列化
             实现了Comparable接口，表示字符串可以比较大小
    3.String内部定义了final char[] value用于储存字符串数据
    4.String:代表了不可变的字符序列，不可变性。
        4.1 当对字符串从新赋值时，不能使用原有value进行赋值，新的区域进行赋值。
        4.2 当现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有value进行赋值
        4.3 当调用String的repacle()方法修改字符串时，也需要重新指定内存区域赋值，不能使用原有value进行赋值
    5.通过字面量的方式(区别于new 方式) 给一个字符串赋值，此时的字符串声明在字符串常量池中
    6.字符串常量池不会存相同内容的字符串
    面试题：String s = new String("abc"); 方式创建对象，在内存中创建了几个对象？
           两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"

     */
    @Test
    public void test() {

        String s1 = "abc"; //字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);  // 比较s1和s2的地址值  常量池不会存两个相同内容的字符串
        s1 = "hello";
        System.out.println(s1);   // hello
        System.out.println(s1 == s2);    //abc
        System.out.println("*****************");
        String s3 = "abc";
        System.out.println(s3.hashCode());
        System.out.println(s2.hashCode());
        s3+="def";
        System.out.println(s3); //abcdef
        System.out.println(s3.hashCode());
        System.out.println("*****************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'f');
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s4.hashCode());
        System.out.println(s5.hashCode());
    }

    @Test
    public void Test2(){
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new + 构造器的方式：此时s3和s4保存的的地址值在在堆 空间中
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false

    }

    @Test
    public void test3(){
        Person p1 = new Person("tom","bob",12);
        Person p2 = new Person("tom","bob",12);
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name1.equals(p2.name1));
        System.out.println(p1.name1 == p2.name1);

    }

    /*
       1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
       2.只要其中一个是变量，结果就在堆中
       3.如果拼接的结果调用intern()方法，返回值在常量池中
     */
    @Test
    public void test4(){
         String s1 = "javaEE";   //字面量定义方式
         String s2 = "hadoop";
         String s3 = "javaEEhadoop";
         String s4 = "javaEE"+"hadoop";
         String s5 = s1+"hadoop";    //
         String s6 = "javaEE" + s2;
         String s7 = s1 + s2;
         String s8 = s5 + s6;

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //flase
        System.out.println(s3 == s6); //false
        System.out.println(s5 == s6); //false
        System.out.println(s5 == s7); //false
        System.out.println(s6 == s7); //false
        System.out.println(s7); //"javaEEhadoop"
        System.out.println(s8);  //"javaEEhadoopjavaEEhadoop"

        String s9 = s5.intern(); //返回值得到的s9使用的常量值中已经存在的"javaEEhadoop "
        System.out.println("s9==s3 " + (s9 == s3));

    }
}




