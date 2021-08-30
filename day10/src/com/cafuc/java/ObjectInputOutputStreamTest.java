package com.cafuc.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputOutputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
 *        以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。

 * 3.要想一个java对象是可序列化的，需要满足相应的需求。
 *   3.1 implements implements Serializable
 *   3.2 static final long serialVersionUID = xxxL;
 *   3.3 ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * 4.序列化机制
 *
 * @author jh
 * @create 2021-08-27 12:21
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    通过ObjectOutputStream实现
     */
@Test
    public void test() {
    ObjectOutputStream oos = null;
    try {
        oos = new ObjectOutputStream(new FileOutputStream("hello.txt"));
        oos.writeObject(new String("我爱北京天安门"));
        oos.flush(); //刷新操作

        oos.writeObject(new Person("Tom",20));
        oos.flush(); //刷新

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if(oos != null)
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/*
反序列化过程：将磁盘文件中的对象还原为内存中的一个java对象
 */
    @Test
    public void test1(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("hello.txt"));

            Object obj = ois.readObject();
            String str = (String) obj;
            Person per = (Person)  ois.readObject();
            System.out.println(str);
            System.out.println(per);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois != null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
