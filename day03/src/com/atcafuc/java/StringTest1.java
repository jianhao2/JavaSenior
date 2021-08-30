package com.atcafuc.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类和其他结构之间的转换
 * @author jh
 * @create 2021-08-12 15:37
 */
public class StringTest1 {

    /*
    String  与基本数据类型、包装类之间的转换
    String --》基本数据类型、包装类
     */
    @Test
    public void test1(){
        String str1 = "123";
//        int i1 = (int) str1;  false!
        int i1 = Integer.valueOf(str1);
        System.out.println(i1);

        Integer a = 456;
        String s2 = String.valueOf(a);
        System.out.println(s2);
    }

    /*
    String 与 char[]之间的转换
    String --> char[]  //调用String.toStringArray()
    chat[] --> String  //调用String的构造器
     */
    @Test
    public void test2(){
        String s1 = "abc123";
        char[] ch = s1.toCharArray();
        System.out.println(ch);
        System.out.println(ch[2]);
        char[] ch1 = new char[]{'5','6','7','8','9'};
        System.out.println(ch1);
        String s2 = new String(ch1);
        System.out.println(s2);
    }

    /*

    String 与 byte[]之间的转换
    String --> byte[]:调用Sting的getBytes()
    byte[] -->  String:调用String的构造器

    编码：字符串 --》字节
    解码：字节   --》 字符串

    解码时，要求解码使用的字符集与编码使用的字符集一致

     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] b1 = s1.getBytes();   //使用默认的字符集进行编码
        System.out.println(Arrays.toString(b1));

        byte[] gbks = s1.getBytes("gbk");  //使用gbk字符集进行编码


        System.out.println(Arrays.toString(gbks));

        System.out.println("********************");

        String s2 = new String(b1);  ////使用默认的字符集进行解码
        System.out.println(s2);

        String s3 = new String(gbks,"gbk");
        System.out.println(s3);
    }


}
