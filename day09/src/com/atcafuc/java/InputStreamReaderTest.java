package com.atcafuc.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流和字符流之间的转换
 *
 * 3. 解码： 字节、字节数组 ----》字符、字符数组
 *    编码： 字符数组、字符串-----》字节、字节数组
 *
 * 4.字符集
 *
 *
 *
 * @author jh
 * @create 2021-08-26 15:39
 */
public class InputStreamReaderTest {

    /*
    此时处理异常仍然使用try-catch-finally
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
        InputStreamReader isr = new InputStreamReader(fis);  //使用系统默认的字符集
        //参数二指明了字符集，使用哪个取决于文件保存时使用的字符集
//        InputStreamReader isr = new InputStreamReader(fis,"gbk");  //使用系统默认的字符集

        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.println(str);

        }

    }

    @Test
    public void test2() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("hello_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        isr.close();
        osw.close();

    }

    @Test
    public void test3() throws IOException {

        File file2 = new File("hello_gbk.txt");
        FileInputStream fis = new FileInputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis,"gbk ");
        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.println(str);

        }

    }
}
