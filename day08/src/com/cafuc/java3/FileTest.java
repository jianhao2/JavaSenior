package com.cafuc.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *  File类的使用
 *  1.File类的一个对象，代表一个文件或者一个文件目录（俗称：文件夹）
 *  2.File类声明在java.io包下
 *  3.File类并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 *  4.后续File类的对象常会作为参数传递的构造器中，指明读取或写入的"终点"。
 *
 * @author jh
 * @create 2021-08-25 17:16
 */
public class FileTest {
    /*
    创建File类的实例

    路径分隔符:
    windows:\\
    unix:/
     */
    @Test
    public void test(){
        //构造器1
        File file = new File("C:\\Users\\Jianhao\\Desktop\\2021 健康记录卡.pdf"); //绝对路径
        File file1 = new File("hello.text");   //相对路径
        System.out.println(file1);
        System.out.println(file);

        //构造器2：
        File file3 = new File("C:\\Users\\Jianhao\\Desktop\\java","code");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3,"hello.txt");
        System.out.println(file4);
    }

    /*
     File类的获取功能
     public String getAbsolutePath()：获取绝对路径
     public String getPath() ：获取路径
     public String getName() ：获取名称
     public String getParent()：获取上层文件目录路径。若无，返回null
     public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     public long lastModified() ：获取最后一次的修改时间，毫秒值

     */
    @Test
    public void test1(){
//        File file = new File("C:\\Users\\Jianhao\\Desktop\\java","code");
        File file1 = new File("hello.txt");
        System.out.println(file1.getName());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }

/*
    如下两方法适用于文件目录：
     public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
*/
    @Test
    public void test2(){
        File file = new File("C:\\Users\\Jianhao\\Desktop\\java\\code\\workspace_idea1");
//        for(String str : file.list()){
//            System.out.println(str);
//
//        }

        File[] files = file.listFiles();
        for(File fi : files){
            System.out.println(fi);
        }
    }

    /*
     File类的重命名功能
     public boolean renameTo(File dest):把文件重命名为指定的文件路径
            要想保证返回true，需要保证file1在硬盘中是存在的，且file2不能在硬盘中存在
     */
    @Test
    public void test3(){

        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\Jianhao\\Desktop\\java\\code\\h1.txt");
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);

    }

    /*
     File类的判断功能
     public boolean isDirectory()：判断是否是文件目录  ！！
     public boolean i 是文件          ！！
     public boolean exists() ：判断是否存在            ！！
     public boolean canRead() ：判断是否可读
     public boolean canWrite() ：判断是否可写
     public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println("-------------------------------------------");

        File file2 = new File("C:\\Users\\Jianhao\\Desktop\\java\\code");
        System.out.println(file2.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /*
     File类的创建功能
     public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
           如果此文件目录的上层目录不存在，也不创建。
     public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
           注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
     */
    @Test
    public void test5() throws IOException {
        File file = new File("hi.txt");
        if(!file.exists()){
            boolean newFile = file.createNewFile();
            System.out.println("创建成功");
        }else{
            file.delete();
            System.out.println("delete");
        }

    }

    //文件目录创建
    @Test
    public void test6(){
        File file = new File("C:\\Users\\Jianhao\\Desktop\\java\\code\\io\\i");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
//        boolean delete = file.delete();
//        System.out.println(delete);
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);

        File file1 = new File("C:\\Users\\Jianhao\\Desktop\\java\\code\\io");
        boolean delete1 = file1.delete();
        System.out.println(delete1);
    }

}
