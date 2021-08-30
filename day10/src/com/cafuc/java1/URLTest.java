package com.cafuc.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 1.URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一资源的地址。
 * 2.格式
 * http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 * 协议      主机名    端口号  资源地址                    参数列表
 *
 * @author jh
 * @create 2021-08-27 17:46
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://baike.baidu.com/item/%E7%AB%AF%E5%8F%A3%E5%8F%B7/10883658?fr=aladdin");
                    //public String getProtocol( ) 获取该URL的协议名
                    //public String getHost( ) 获取该URL的主机名
                    //public String getPort( ) 获取该URL的端口号
                    //public String getPath( ) 获取该URL的文件路径
                    //public String getFile( ) 获取该URL的文件名
                    //public String getQuery( ) 获取该URL的查询名
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
