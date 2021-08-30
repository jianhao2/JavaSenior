package com.atcafuc.java2;

/**
 * 线程通信例子：使用两个线程打印 1-100。线程1，线程2，交替打印。
 *
 * 涉及到的3个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就会唤醒优先级高的
 * notify(): 一旦执行此方法，就会唤醒所有被wait的线程中
 *
 * 说明：
 * 1.wait(), notify(), notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait(), notify(), notifyAll()三个方法的调用者，必须是同步代码块或同步方法中的同步监视器
 *           否者会出现异常
 * 3. wait(), notify(), notifyAll()三个方法是定义在java.lang.Object类中的
 *
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2.不同点：a、两个方法声明的位置不同：Thread类中声明sleep(), Object类中声明wait()
 *          b、调用要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
 *          c、关于是否释放同步监视器，在同步代码块或同步方法中，sleep()不释放锁,wait()释放锁。
 *
 *
 * @author jh
 * @create 2021-08-10 14:14
 */

class Number implements Runnable {
    public static int num = 1;


    @Override
    public void run() {
        while (true) {
           synchronized (this) {
               notify();
               if(num<=100){
                System.out.println(Thread.currentThread().getName()+"----"+num);
                num++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                break;
            }

        }
        }
    }

}

public class CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
