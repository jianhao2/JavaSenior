package com.atcafuc.java;

import org.junit.Test;

/**
 * 关于StringBuffer and StringBuilder的使用
 * @author jh
 * @create 2021-08-12 16:37
 */
public class StringBufferBuilderTest {
    /*
    String StringBuffer StringBuilder
    String : 不可变的字符序列；底层使用char[]存储
    StringBuffer ： 可变的字符序列；线程安全的，效率低；底层使用char[]存储
    StringBuilder :  可变的字符序列：Jdk5.0新增，线程不安全的，效率高；底层使用char[]存储     尽可能用

    源码分析：
        String str = new String();  //char[] value = new char[0]:
        String str1 = new String("abc");  //char[] value = new char[]{'a','b','c'}
        StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16]; 底层创建一个长度是16的数组
        System.out.println(sb2.length());   //
        sb1.append('a'); //value[0] = 'a';
        sb1.append('b'); //value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length() + 16];

        //问题1.System.out.println(sb2.length()); // 3
        //问题2.扩容问题：如果添加的数据底层数组盛不下了，那就需要扩容底层的数组。
                默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中。

                指导意义：开发中建议使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

        对比String StringBuffer StringBuilder三者的效率：  StringBuilder  >  StringBuffer  >>   String
     */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        String str = sb1.toString();
        System.out.println(str);
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        System.out.println(sb1.length());
        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }


    /*
    StringBuffer 的常用方法
        StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
        StringBuffer delete(int start,int end)：删除指定位置的内容
        StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
        StringBuffer insert(int offset, xxx)：在指定位置插入xxx
        StringBuffer reverse() ：把当前字符序列逆转
        public int indexOf(String str)
        public String substring(int start,int end)   返回[start,end）字符串
        public int length()
        public char charAt(int n)
        public void setCharAt(int n ,char ch)

        总结：
        增 删 改 查 插 长度 遍历 toString()
      */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer();
        s1.append('a');
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        StringBuffer s2 = new StringBuffer("abcde");
//        s2.delete(1,3);   //删掉1 2
//        s2.replace(2,4,"hello");
//        s2.insert(2,"nihao");
        s2.reverse();
        System.out.println(s2);

    }
}
