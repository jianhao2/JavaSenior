package com.atcafuc.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式3：lock锁------JDK 5.0 新增
 *
 * 1.面试题：synchronized 与  lock锁的异同
 *    相同：二者都可以解决线程安全问题
 *    不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *          lock需要手动的启动同步（lock），同时结束同步也需要手动的实现（unlock()）
 *
 *
 *
 * @author jh
 * @create 2021-08-10 11:39
 */
public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}

class Window implements Runnable {
    private static int ticket = 100;

    //1.实例化ReenteantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            // 2.调用lock()
            lock.lock();
            try {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {

                //3.调用解锁的方法：unlock()
                lock.unlock();
            }
        }
    }
}
