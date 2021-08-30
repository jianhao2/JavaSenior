package com.atcafuc.java;

/**
 * 例子：创建三个窗口买票，总票数100张
 * 存在线程安全问题
 * 慎用this当作同步监视器
 * @author jh
 * @create 2021-08-09 14:59
 */

class Window2 extends Thread{

    private static int ticket = 100; //static
    static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (Window2.class){  //class clazz = Window2.class, Window2.class只加载一次
            //synchronized(this)错误，this代表w1,w2,w3三个对象
                if(ticket > 0){
                    System.out.println(getName()+": 买票： 票号为"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }

        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();
        w1.setName("w1");
        w2.setName("w2");
        w3.setName("w3");
        w1.start();
        w2.start();
        w3.start();
    }
}