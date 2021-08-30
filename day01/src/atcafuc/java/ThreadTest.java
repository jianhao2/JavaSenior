package atcafuc.java;

/**
 * 多线程的创建，方式一：继承于Thred类
 * 1.创建一个继承于Thread类的run（）
 * 2.重写Thread的run（）--> 此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start（）
 *
 * 例子：遍历一下100以内的偶数
 * @author jh
 * @create 2021-08-09 11:16
 */

// * 1.创建一个继承于Thread类的run（)
class MyThread extends Thread{
    //2.重写Thread的run（）
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {

        //3.创建Thread类的子类的对象
        MyThread mt = new MyThread();

        // 4.通过此对象调用start（）1.启动当前线程 2.调用当前线程的run()
        mt.start();
        //问题一：不能通过调用run()的方式启动当前线
        //问题二：不能重复多次调用，同一对象.start(),需要重新创建一个线程的对象
        MyThread mt2 = new MyThread();
        mt2.start();




        //如下操作仍然在main线程中执行
        for(int i=0;i<100;i++){

            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i+"************main");
            }
        }
//        mt.start();
        System.out.println("hello"+"主线程");
    }

}
