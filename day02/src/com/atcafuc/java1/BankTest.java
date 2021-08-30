package com.atcafuc.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author jh
 * @create 2021-08-10 10:07
 */
public class BankTest {
    public static void main(String[] args) {

        R r1 = new R();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();


    }
}


class R implements Runnable{
    static int num = 10;
    @Override
    public void run() {
        for(int i=0;i<num;i++ ){
        Bank b = Bank.getInstance();
            System.out.println(b + "-------" + Thread.currentThread().getName() + "----" + i);
//        return 1;
        }
    }
}


class Bank{
    private Bank(){}
    private static Bank instance = null;



    //方式一：效率稍差
//    public static  Bank getInstance(){  //锁是当前类的本身
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }



    //方式二: 效率更高
    public static  Bank getInstance(){  //锁是当前类的本身
    if(instance == null){
    synchronized (Bank.class) {
        if(instance == null) {
            instance = new Bank();
        }
    }
}

    return instance;
}
}
