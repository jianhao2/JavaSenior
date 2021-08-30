package com.atcafuc.java2;

import java.util.concurrent.*;

/**
 * 创建现成的方式四：使用线程池
 * @author jh
 * @create 2021-08-10 16:14
 */

class NumberThread  implements  Runnable{
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"-----"+i);
            }
        }
    }
}

class NumThread1 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+"----"+i);
                sum +=i;
            }

        }
        return sum;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        // 1.提供指定线程数量的连接池
        ExecutorService service  = Executors.newFixedThreadPool(10);


        //设置线程池的属性
        System.out.println(service.getClass());
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);


        FutureTask futureTask = new FutureTask(new NumThread1());
        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread()); //适用于Runnable
        service.execute(new NumberThread()); //适用于Runnable
//        service.submit(Callable callable);  //适用于Callable
//        FutureTask futureTask = new FutureTask(new NumThread1());

        //关闭连接池
        service.shutdown();

    }
}
