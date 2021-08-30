package com.atcafuc.java1;

import com.atcafuc.java.Person1;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1. Set接口的矿建
 * |-----Collection接口：单列集合，用来存储一个一个的对象
 *      |---Set接口：存储无序的、不可重复的数据   可用来做数据过滤
 *              |---HashSet：Set接口的主要实现类：线程不安全：可以存储null值
 *                  |---LinkedHashSet：作为HashSet的子类：遍历其内部数据时，可以按照添加的顺序遍历
 *              |---TreeSet：可以按照添加对象的指定属性，进行排序。
 *
 * 2. 要求：向Set中添加的数据，其所在类一定要重写hashCode()和equals()
 *    要求：重写的hashCode()和eauals()尽可能保持一致性，相等的对象必须具有相等的散列码
 *      重写两个方法的小技巧：对象中用作equals()方法比较的Field，用应该用来计算hashCode。
 *
 * @author jh
 * @create 2021-08-23 17:01
 */
public class SetTest {
    /*
        Set:存储无序的、不可重复的数据，使用都是Collection中声明过的方法
        以HashSet为例说明：
        1. 无序性：不等于随机性。存储的数据在底层数组中并非按照索引的顺序添加，
            而是根据数据的哈希值决定的。

        2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true。即：相同的元素只能有一个。

        二、添加元素的过程，以HashSet为例：
        向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
        此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
        数组此位置上是否已经有元素：
                    如果此位置上没有其他元素，则元素a添加成功
                    如果此位置上有其他元素b(或链表形式存在的多个元素)，则比较元素a与元素b的hash值：
                        如果hash值不同，则元素a添加成功。
                        如果hash值相同，进而需要调用元素a所在类的equlas()方法：
                                equals()返回true，元素a添加失败
                                equals()返回false，元素添加成功 -----》情况2
        对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式进行存储。
        jdk7：元素a数组，指向原来元素。
        jdk8：原来元素在数组中，指向元素a

        HashSet底层：链表+数组

     */

    @Test
    public void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("aa");
        set.add("cc");
        set.add(new Person1("Tom",12));
        set.add(new Person1("Tom",12));
        set.add(77);
          set.add(123);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        Person1 p1 = new Person1("Tom",12);
        Person1 p2 = new Person1("Tom",12);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }

    /*

     */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("aa");
        set.add("cc");
        set.add(new Person1("Tom",12));
        set.add(new Person1("Tom",12));
        set.add(77);
        set.add(123);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}
