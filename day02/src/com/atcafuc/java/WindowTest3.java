package com.atcafuc.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示的声明。
 * 2.非静态的同步方法，同步监视器是：this
 *   静态的同步方法，同步监视器是：当前类的本身
 *
 * @author jh
 * @create 2021-08-10 9:41
 */
class Window3 implements Runnable{
    private  int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while(true) {

//                if (ticket > 0) {
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                    System.out.println(Thread.currentThread().getName() + ": 买票： 票号为" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
            show();

        }
    }

    private synchronized void show(){   //同步监视器：this
        if (ticket > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            System.out.println(Thread.currentThread().getName() + ": 买票： 票号为" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
//        Window1 w2 = new Window1();   windows不需要重复造对象

        Thread t1 =  new Thread(w1);
        Thread t2 =  new Thread(w1);
        Thread t3 =  new Thread(w1);
        t1.start();
        t2.start();
        t3.start();
    }
}


