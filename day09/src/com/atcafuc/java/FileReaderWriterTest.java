package com.atcafuc.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向： 输入流、输出流
 * 3.流的单位：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类              节点流(文件流)                                       缓冲流（处理流的一种）
 * InputStream        FileInputStream (read(byte[], buffer))              BufferedInputStream (read(byte[], buffer))
 * OutputStream       FileOutputStream (writer(byte[], buffer,0,len))     BufferedOutputStream (writer(byte[], buffer,0,len))
 * Reader             FileReader (read(char[] cbuf))                      BufferedReader (read(char[] cbuf) / readline())
 * Writer             FileWriter (read(char[] cbuf,0,len))                BufferedWriter (read(char[] cbuf,0,len))
 *
 * @author jh
 * @create 2021-08-26 10:51
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");   //相较于当前工程
        System.out.println(file.getAbsolutePath());
        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2.异常处理：为了保证流资源一定可以执行关闭操作。需要使用try—catch-finally处理
    3.读入的文件一定要存在，否则会报FileNotFoundException。

     */
    @Test
    public void test()  {
        //1.实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");  //相较于当前的Module
//        File file = new File("C:\\Users\\Jianhao\\Desktop\\Zhang, Wei; Peng, Gaoliang; Li, Chuanhao; Chen, Yuanhang; Zhang, Zhujun  (2017). A New Deep Learning Model for Fault Diagnosis with Good Anti-Noise and Domain Adaptation Ability on Raw Vibration Signals. Sensors, s17020425.pdf");  //相较于当前的Module

//        System.out.println(file.getAbsolutePath());

        FileReader fr = null;
        //2.提供具体的流
        try {
            fr = new FileReader(file);
//        System.out.println(fileReader.read());

            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);  //(chat) data 把int转换为char
//            data = fr.read();
//        }

            //方式二：
            int data;
            while((data = fr.read())!= -1){
                System.out.print((char)data);  //(chat) data 把int转换为char
            }

            //4.流的关闭操作  没关闭容易导致内存泄露问题

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                       fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    //对read()操作升级，使用read的重载方法
    @Test
    public void testFileReader1(){

        FileReader fr = null;

        try {
            //1.File类的实例化
            File file  = new File("hello.txt");

            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3.读入操作
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                //错误写法：
//                for(int i=0;i<cbuf.length;i++){
//                    System.out.print(cbuf[i]);
//                }

                //正确写法
//                for(int i = 0;i<len;i++){
//                    System.out.print (cbuf[i]);
//                }

//                String str = String.valueOf(cbuf).substring(0,len);
                String str = new String(cbuf,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //4.资源的关闭
    }


    /*
        1.输出操作，对应的File可以不存在的。
           File对应的硬盘中的文件如果不存在：在输出过程中，会自动创建此文件。
                                 如果存在：看流构造器的第二个参数。true：不覆盖、false：覆盖
     */
    @Test
    public void testFileWriter() throws IOException {
        //1.提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");

        //2.提供FileWriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file,false);

        //3.写出操作
        fw.write("nihao china" + "\n");
        fw.write("nihao nanjing");


        //4.流资源的关闭
        fw.close();

    }

    @Test
    public void testFileReadrFileWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.指明File类的对象，指明读入和写入的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //2.提供输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf中字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
               fw.write(cbuf,0,len);
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

}
