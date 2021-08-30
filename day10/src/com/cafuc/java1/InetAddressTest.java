package com.cafuc.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 通信要素一、IP和端口号
 * 1.唯一的标识 Internet 上的计算机（通信实体）
 * 2.在java中使用InetAddress类代表IP
 * 3.IP分类：IPv4 和 IPv6；万维网 和 局域网
 * 4.域名：www.baidu.com www.sina.com
 * 5.本地回路地址：127.0.0.1
 * 6.如何实例化InetAddress:两个方法：getByName(String host) 、getLocalHost()
 * 7. 端口号标识正在计算机上运行的进程（程序）
 *  不同的进程有不同的端口号
 *  被规定为一个 16 位的整数 0~65535。  端口分类：
 *  公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口
 * 80，FTP占用端口21，Telnet占用端口23）  注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占
 * 用端口8080，MySQL占用端口3306，Oracle占用端口1521等）。  动态/私有端口：49152~65535。 端口号与IP地址的组合得出一个网络套接字：Socket。
 * @author jh
 * @create 2021-08-27 15:51
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.1");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            System.out.println(InetAddress.getLocalHost());   //本地地址
            System.out.println(inet2.getHostAddress());  //ip地址
            System.out.println(inet2.getHostName());    //域名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
