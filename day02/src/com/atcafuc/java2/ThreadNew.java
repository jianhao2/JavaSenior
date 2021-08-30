package com.atcafuc.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口 比 实现Runnable接口方式强大
 *
 * 1.call()可以有返回值
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.Callable支持泛型
 *
 *
 *
 *
 *
 * @author jh
 * @create 2021-08-10 15:25
 */

class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum +=i;
            }

        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
//        try {
//           int a = (int) new NumThread().call();
//            System.out.println(a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);

        //将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //获取Callable中call()的返回值
            Object sum = futureTask.get();
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
