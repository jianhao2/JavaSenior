package com.atcafuc.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream 和 FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件(.txt,.java,.c,.cpp),使用字符流
 * 2.对于非文本文件，使用字节流处理
 *
 * @author jh
 * @create 2021-08-26 13:43
 */
public class FileInputOuputStream {

    //只用字节流处理文本文件可能出现乱码
    @Test
    public void test(){
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            //1.指明File类的对象，指明读入和写入的文件
            File srcFile = new File("8-26.jpg");
//            File srcFile = new File("hello.txt");
            File destFile = new File("8-26-1.jpg");



            //2.提供输入流和输出流的对象
            fr = new FileInputStream(srcFile);
            fw = new FileOutputStream(destFile);

            //3.数据读入和写出操作
            byte[] b = new byte[1024];
            int len;//记录每次读入到b中字符的个数
            while((len = fr.read(b)) != -1){

//                String str = new String(b,0,len);
//                System.out.println(str);

                //每次写出len个字符
                fw.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //指定路径下文件的复制  文本文件也可用字节流复制
    public void copy(String srcPath,String destPath){
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            //1.指明File类的对象，指明读入和写入的文件
            File srcFile = new File(srcPath);
//            File srcFile = new File("hello.txt");
            File destFile = new File(destPath);



            //2.提供输入流和输出流的对象
            fr = new FileInputStream(srcFile);
            fw = new FileOutputStream(destFile);

            //3.数据读入和写出操作
            byte[] b = new byte[1024];
            int len;//记录每次读入到b中字符的个数
            while((len = fr.read(b)) != -1){

//                String str = new String(b,0,len);
//                System.out.println(str);

                //每次写出len个字符
                fw.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopy(){
        long start = System.currentTimeMillis();
        copy("22.avi","22-1.avi");
        long end = System.currentTimeMillis();
        System.out.println("复制时间为" + (end - start));   //time 549
    }

}
