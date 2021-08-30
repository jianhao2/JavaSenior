package atcafuc.java;

/**
 * 创建多线程方法2：实现Runable接口
 * 1.创建一个实现了runnable接口的类
 * 2.实现类去实现runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *开发中优先选择：实现runnable接口的方式
 * 原因：1.实现的方式没有类的单继承性的局限性
 *      2. 实现的方式更适合来处理多个线程有共享数据的情况
 *
 * @author jh
 * @create 2021-08-09 15:10
 */

class MyThread3 implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class TheadTest1 {
    public static void main(String[] args) {
        MyThread3 mt3 = new MyThread3();
        new Thread(mt3).start();  //!!

    }
}
