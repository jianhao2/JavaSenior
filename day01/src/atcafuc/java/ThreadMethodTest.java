package atcafuc.java;

/**
 *测试Thread中的常用方法：
 * 1.start():启动当前线程，调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread（）：静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName（）：设置当前线程  的名字
 * 6.yield（）：释放当前cpu的执行权
 * 7.join(): 在线程a中调用线程b的join（），此时线程a就进入阻塞状态，知道线程b完全执行以后，线程a才结束阻塞状态。
 * 8.stop（）：已过时。强制结束线程。
 * 9.sleep（long millitime）：让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前
 *                              线程时阻塞状态的。
 * 10.i是Alive()：判断当前线程是否存活
 *
 * 1.线程优先级：
 * MAX_PRIORITY: 10
 * MIN_PRIORITY: 1
 * NORM_PRIORITY:  5
 *
 * 2.如何获取和设置当前线程的优先级
 *  getPriority():
 *  setPriority():
 *  高优先级抢占低优先级线程的cpu执行权，概率问题。不是必然。
 *
 *
 * @author jh
 * @create 2021-08-09 13:26
 */

class HelloThread extends Thread{
    public int a = 100;
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+"-----"+i);

            }
        }
        System.out.println(isAlive());
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        HelloThread h1 = new HelloThread();
        System.out.println(h1.a);
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        h1.setName("线程一");
        h1.a = 101;
        System.out.println(h1.a);
        for(int i=1;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+"-----"+i);
//                System.out.println(Thread.currentThread().isAlive());
            }

//            if(i%20==0){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());
    }
}
