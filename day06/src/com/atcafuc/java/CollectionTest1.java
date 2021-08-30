package com.atcafuc.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 结论：
 * 向Collection接口的实现类的对象实现数据obj是，要求obj所在类的equals()方法要重写。
 *
 * @author jh
 * @create 2021-08-23 10:48
 */
public class CollectionTest1 {
    @Test
    public void test1(){
        //contains
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(12);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));

        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Bob", 8)));
        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(12);
        coll1.add(false);
        System.out.println(coll.containsAll(coll1));
        Collection coll2 = Arrays.asList("12445",20,1);
        System.out.println(coll.containsAll(coll2));
    }

    @Test
    public void test2(){
        //remove(Object obj):   从当前集合中移除Obj元素。
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));
        System.out.println(coll);
        coll.remove(1234);
        System.out.println(coll);

        //removeAll(Collection coll):  差集操作，从当前集合移除和obj共有的元素。
        Collection coll1 = Arrays.asList(123,20,100);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));

        //5.retainAll(Collection coll): 交集，获取当前集合与coll1集合的交集，并返回给当前交集
//        Collection coll1 = Arrays.asList(101,100,123);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):
        Collection coll1 = new ArrayList();
        coll1.add("12445");
        coll1.add(123);
        coll1.add(20);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Bob",8));
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));

        // 7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8. 集合 ---》数组：toArray()
        System.out.println(coll.getClass());
        Object[] arr = coll.toArray();
        System.out.println(arr);

        //数组 ---》集合？
        List list = Arrays.asList(new String[]{"aa","bb","cc"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());  //1

        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size()); //2

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试。

    }



}
