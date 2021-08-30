package com.atcafuc.java;

import org.junit.Test;

import java.io.*;

/**
 *  处理流之一：缓冲流的使用
 *
 *  1.缓冲流
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 *  2.作用：提供流的读取、写入的速度
 *      提高读写速度的原因：内部提供了一个缓冲区
 *
 * @author jh
 * @create 2021-08-26 14:21
 */
public class BufferedTest {

    /*
    实现为文本文件的复制
     */
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("8-26.jpg");
            File destFile = new File("8-26.2.jpg");

            //2.造流
            //2.1 造字节流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //说明：关闭外层流的同时，内层的流也会自动进行关闭。
//            fis.close();
//            fos.close();
        }

    }

    //文件复制的方法
    public void copy(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.造流
            //2.1 造字节流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //说明：关闭外层流的同时，内层的流也会自动进行关闭。
//            fis.close();
//            fos.close();
        }
    }

    @Test
    public void testCopy(){
        long start = System.currentTimeMillis();
        copy("22.avi","22-1.avi");
        long end = System.currentTimeMillis();
        System.out.println("复制时间为" + (end - start));   //time 147
    }

    @Test
    public void test1(){
        byte b = 124;
        byte b1 = (byte) (b ^5);



    }
}
