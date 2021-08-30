package com.atcafuc.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *9.iterator():返回Iterator接口的实例，
 *             用于遍历集合元素。放在IteratorTest.java中测试。
 *
 *集合元素的遍历操作，使用迭代器Iterator接口
 *  1.内部的方法：hasNext() and next()
 *  2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 *      默认游标都在集合的第一个元素之前。
 *  3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove().
 *
 *
 * @author jh
 * @create 2021-08-23 13:30
 */

public class IteratorTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));

        Iterator iterator = coll.iterator();
        //方式一：
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        //方式二: 推荐
        //hasNext(): 判断是否还有下一个元素
        while(iterator.hasNext()){
            //next(): 1.指针下移 2、将下移以后指针所指的集合位置上的元素返回。
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));
        Iterator iterator = coll.iterator();

        //错误方式一：
//        while(iterator.next()!=null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        int i = 10;
        while(coll.iterator().hasNext() && i>1){
            System.out.println(coll.iterator().next());
            i--;
        }
    }

    //测试Iterator 中的 remove()
    @Test
    public void  test3(){
        Collection coll = new ArrayList();
        coll.add("12445");
        coll.add(123);
        coll.add(20);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Bob",8));

        Iterator iterator = coll.iterator();
        //删除集合中的"Tom "
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            };
        }

        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
        System.out.println(iterator1.next());
        }

    }

}
