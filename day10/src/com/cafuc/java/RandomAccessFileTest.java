package com.cafuc.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput、DataOutput这两个接口，
 * 也就意味着这个类既可以读也可以写
 * 2.RandomAccessFile可以是输入流也可以是输出流
 * 3.如果RandomAccessFile作为输出流时，写出的文件如果不存在，则在执行过程中自动创建，
 *   如果文件存在，则对原有文件内容覆盖（默认为从头覆盖）。
 *
 * @author jh
 * @create 2021-08-27 14:34
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("8-26.jpg"),"r");
            raf2 = new RandomAccessFile(new File("8-26_1.jpg"),"rw");
            byte[] bytes = new byte[1024];
            int len;
            while((len = raf1.read(bytes)) != -1){
                raf2.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");
//        raf1.seek(3);  //将指针调到角标为3的位置
        System.out.println(new File("hello.txt").length());
        raf1.write("断s多个".getBytes());
        raf1.close();
        System.out.println(new File("hello.txt").length());
//        System.out.println("a124你好反垄断".getBytes());
    }

    /*
    使用RamdonAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");
        raf1.seek(3);  //将指针调到角标为3的位置
        byte[] buffer = new byte[20];
        int len;
        StringBuilder sb = new StringBuilder((int) new File("hello.txt").length());
        while((len = raf1.read(buffer)) != -1){
                sb.append(new String(buffer,0,len));
        }

        //调回指针，写入
        raf1.seek(3);
        raf1.write(("12345"+ sb.toString()).getBytes());
        raf1.close();
    }


}
