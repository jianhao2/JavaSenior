package atcafuc.java;

/**
 * 例子：创建三个窗口买票，总票数100张
 * 存在线程安全问题
 *
 * @author jh
 * @create 2021-08-09 14:59
 */

class Window extends Thread{

    private static int ticket = 100; //static

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(getName()+": 买票： 票号为"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("w1");
        w2.setName("w2");
        w3.setName("w3");
        w1.start();
        w2.start();
        w3.start();
    }
}
