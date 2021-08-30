package com.atcafuc.java;

/**
 * @author jh
 * @create 2021-08-10 9:54
 *
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 *
 */
class Window4 extends Thread{

    private static int ticket = 100; //static
    static Object obj = new Object();
    @Override
    public void run() {
        while(true){
//            synchronized (Window4.class){  //class clazz = Window4.class, Window4.class只加载一次
//                //synchronized(this)错误，this代表w1,w2,w3三个对象
//                if(ticket > 0){
//                    System.out.println(getName()+": 买票： 票号为"+ticket);
//                    ticket--;
//                }else{
//                    break;
//                }
//
                show();
                if(ticket<=0){
                    break;
                }
        }
    }

    private static synchronized void show() {   //静态方法 同步监视器是当前类的对象
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": 买票： 票号为" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("w1");
        w2.setName("w2");
        w3.setName("w3");
        w1.start();
        w2.start();
        w3.start();
    }
}
