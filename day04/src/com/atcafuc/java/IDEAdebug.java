package com.atcafuc.java;

import org.junit.Test;

/**
 * @author jh
 * @create 2021-08-16 22:13
 */
public class IDEAdebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());  //4
        System.out.println(sb);    // "null"
        System.out.println(str);
//        String str1 = "null";
        StringBuffer sb1 = new StringBuffer(str);  //抛异常
        System.out.println(sb1);
    }

    @Test
    public void test(){
        String str = null;
        System.out.println(str.length());
    }

}
