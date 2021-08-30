package atcafuc.java;

/**
 * 例子：创建三个窗口买票，总票数100张,使用runnable接口方式
 *
 * @author jh
 * @create 2021-08-09 15:27
 */

class Window1 implements Runnable{
    private  int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+": 买票： 票号为"+ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
//        Window1 w2 = new Window1();   windows不需要重复造对象
        new Thread(w1).start();
        new Thread(w1).start();
    }
}
