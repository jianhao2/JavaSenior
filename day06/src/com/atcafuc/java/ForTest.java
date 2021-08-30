package com.atcafuc.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 *
 * @author jh
 * @create 2021-08-23 14:00
 */
public class ForTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));

        // for(集合中元素的类型  局部变量 ： 集合对象)
        // 内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test1(){
        // for(数组元素的类型  局部变量 ： 数组对象)
        int[] arr = new  int[]{1,2,3,4,7,5,4,5,6,8};
        for(int x : arr){
            System.out.println(x);
        }
    }

    @Test
    public void test2(){
        String[] arr = new String[]{"aa","aa","aa","aa"};
        for(int i=0;i<arr.length;i++){
            arr[i] = "bb";
        }

        for(String s : arr){
            s = "cc";
        }

        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
