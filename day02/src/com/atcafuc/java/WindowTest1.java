package com.atcafuc.java;

/**
 * 例子：创建三个窗口买票，总票数100张,使用runnable接口方式
 *
 *  1.问题买票过程中，出现了重票、错票 --> 出现了线程安全问题
 *  2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成，其他线程参与进来，也操作车票
 *  3.解决：当一个线程在操作ticket的时候，其他线程不能参与进来。直到a操作完ticket时，其他线程
 *          才可以开始操作ticket。这种情况即使线程a出现阻塞，也不能被改变。
 *  4.在java中，通过同步机制，解决线程的安全问题
 *    方法一  ：synchronized(同步监视器){
 *           //需要被同步的代码
 *          }
 *          说明：1.操作共享数据的代码即为需要被同步的代码
 *               2.共享数据：多个线程共同操作的变量。比如：ticket
 *               3.同步监视器，俗称：锁。任何一个类的对象，多可以  充当锁。
 *                  要求：多个线程必须共用同一把锁。
 *
 *    方法二：
 *           如果操作共享数据的代码完整地声明在一个方法中，我们不妨将此方法声明同步。
 *
 *
 *
 *
 *  5.同步的方式，解决了线程的安全问题。
 *    操作同步代码时，只能有一个线程参与，其他线程等待，相遇于是一个单线程的过程，效率低。----局限性
 *
 *
 * @author jh
 * @create 2021-08-09 15:27
 */

class Window1 implements Runnable{
    private  int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (this){//synchronized (obj) {
                Object obj = new Object();
                if (ticket > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ": 买票： 票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
//        Window1 w2 = new Window1();   windows不需要重复造对象
        new Thread(w1).start();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}
