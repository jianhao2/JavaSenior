package com.atcafuc.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection、Map的工具类
 *
 * 面试题：Collections 和 Collection的区别
 *
 * @author jh
 * @create 2021-08-24 16:03
 */
public class CollectionsTest {
    /*
排序操作：（均为static方法）
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

查找、替换
    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
    给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)
    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
    List 对象的所有旧值
     */

    @Test
    public void test(){
        List list1  = Arrays.asList(1,2,5,4,3,7,6,7,9);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        Collections.reverse(list1);
        System.out.println(list1);
    }

    @Test
    public void test1(){
        List list1  = Arrays.asList(1,2,5,4,3,7,6,10,9);
        List list2  = Arrays.asList(new Object[list1.size()]);
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        Collections.copy(list2,list1);
        System.out.println(list2);

        /*
        Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，
        从而可以解决多线程并发访问集合时的线程安全问题
         */
        List list = Collections.singletonList(list1);


    }

}
