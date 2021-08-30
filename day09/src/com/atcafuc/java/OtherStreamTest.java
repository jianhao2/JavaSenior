package com.atcafuc.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author jh
 * @create 2021-08-26 16:18
 */
public class OtherStreamTest {

    /*
    1.标准的输入、输出流
        1.1：
           System.in:标准的输入流，默认从键盘输入
           System.out:标准的输出 流，默认从控制台输出
        1.2：
        System类的SetIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的

        1.3.练习：从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
            进行输入操作，直至当输入“e”或者“exit”时，退出程序。
        方法一、使用Scanner实现、调用next()返回一个字符串
        方法二、使用System.in实现。   System.in ---->  转换流 --->BufferedReader的ReadLine()
     */
    @Test
    public void test(){
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if("exit".equalsIgnoreCase(data) || "e".equalsIgnoreCase(data)){   //避免空指针问题
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

@Test
public void test2(){
        String s = "abgvd";
    System.out.println(s.toUpperCase());

}

    public static void main(String[] args) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(System.in);   //从键盘输入
            br = new BufferedReader(isr);
            while(true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if("exit".equalsIgnoreCase(data) || "e".equalsIgnoreCase(data)){   //避免空指针问题
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
