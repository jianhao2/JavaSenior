package com.atcafuc.java2;

/**
 * 线程通信应用
 * 生产者，消费者，店员
 *
 *
 * 分析：
 * 1.是否是多线程问题？  是，生产者线程，消费者线程
 * 2.是否有线程安全问题？ 是，店员（或产品）
 * 3.如何解决线程的安全问题？  同步机制，有三种方法。
 * 4.是否涉及线程通信？是
 *
 * @author jh
 * @create 2021-08-10 14:51
 */

class Clerk{
    private int productCount = 0;


    public synchronized void  produceProduct() { //生产产品
//        notify();
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+
                    ":开始生产第"+productCount+"个产品");
            notify();
        }else{

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() { //消费产品
//        notify();
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+
                    ":开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else{

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{ //生产者
    private Clerk clerk = new Clerk();

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始生产产品");
        while(true){
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Customer extends Thread{  //消费者
    private Clerk clerk = new Clerk();

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费产品");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk  =  new Clerk();
        Producer p1 = new Producer(clerk);
        Customer c1 = new Customer(clerk);
        p1.setName("线程一");
        c1.setName("线程二");
        p1.start();
        c1.start();
    }
}
