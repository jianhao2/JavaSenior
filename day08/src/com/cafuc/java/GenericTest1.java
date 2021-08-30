package com.cafuc.java;

import org.junit.Test;

import java.util.List;

/**
 * 如何自定义范型结构：泛型类、泛型接口；泛型方法.
 * 1. 关于自定义泛型类、泛型接口：
 * @author jh
 * @create 2021-08-25 14:31
 */
public class GenericTest1 {

    @Test
    public void test(){
        //如果定义了泛型类，实例没有指明类的泛型，则认为此泛型类为Object类型
        //要求：如果定义了类的带泛型的，建议实例化时要指明类的泛型。
        Order<String> order = new Order<>("abc",123,"edf");
        System.out.println(order.toString());
    }

    @Test
    public void test1(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型的类型。则实例化子类对象时，不需要指明泛型。
        subOrder.setOrderT(11);

        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("order1c");
    }

    //测试泛型方法
    @Test
    public void test2(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);

    }
}
