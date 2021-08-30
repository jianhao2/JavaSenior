package atcafuc.exer;

/**
 * 练习，创建两个线程，一个线程遍历100以内的偶数，一个线程便利100以内的基数
 * @author jh
 * @create 2021-08-09 11:54
 */

class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"-----"+i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() +"-----"+ i);
            }
        }

    }
}

public class TreadDemo {
    public static void main(String[] args) {
//        Thread mt1 = new MyThread1();
//        Thread mt2 = new MyThread2();
//        mt1.start();
//        mt2.start();
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+"-----"+i);
                    }
                }
            }
        }.start();

        new Thread(){ @Override
        public void run() {
            for(int i=0;i<100;i++){
                if(i%2!=0){
                    System.out.println(Thread.currentThread().getName()+"-----"+i);
                }
            }
        }
        }.start();
    }

}
