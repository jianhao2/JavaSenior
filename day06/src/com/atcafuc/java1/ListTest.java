package com.atcafuc.java1;

import com.atcafuc.java.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
*       |-----Collection接口：单列集合，用来存储一个一个的对象
*           |---List接口:存储有序的、可重复的数据    ----》动态数组
*              |---ArrayList：List接口的主要实现类，线程不安全的，效率高；底层使用Object[] elementData存储
 *             |---LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用的是双向链表存储
 *             |---Vector： List接口的古老实现类，线程安全，效率低；底层使用Object[] elementData存储
 *
 *     2.ArraysList的源码分析：
 *       2.1 jdk7.0情况下
 *          ArraysList list = new ArraysList(); //底层创建了长度是10的Object[]数组elementData
 *          list.add(123); //elementData[0] = new Integer(123);
 *          ...
 *          list.add(11); //如果此次的添加导致底层elementData数组容量不够，则扩容。
 *          默认情况下，扩为为原来的1.5倍，同时需要将原有的数组中的数据复制到新的数组中。
 *
 *          结论：建议开发使用带参的构造器：ArraysList list = new ArraysList(int capacity)
 *
 *
 *      2.2 jdk 8中ArraysList的变化：
 *          ArraysList list = new ArraysList();  //底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *          list.add(123); //第一次调用add()时，底层才创建长度为10的数组，并将数据添加到 elementData
 *          ...
 *          后续的添加操作和扩容操作与jdk7.0 无异。
 *
 *      2.3 小结：jdk7中的ArraysList的对象的创建类似于单例的饿汉式，
 *              而jdk8中的ArraysList的对象的创建类似于单例的懒汉式的创建，
 *              延迟了数组的创建，节省内存。
 *
 *
 *
 *    3.LinkedList的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123); //将123封装到Node中，创建了Node对象。
 *
 *      其中，Node定义：双向链表
*    private static class Node<E> {
*         E item;
*         Node<E> next;
*         Node<E> prev;
*
*         Node(Node<E> prev, E element, Node<E> next) {
*             this.item = element;
*             this.next = next;
*             this.prev = prev;
*         }
*     }
 *
 *
 *
 *
 *  面试题：ArrayList、LinkedList、Vector三者的异同？
 *  同：三各类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据。
 *  不同：见上
 *
 *
 *  5.List接口中的常用方法
 *
 * @author jh
 * @create 2021-08-23 15:25
 */
public class ListTest {


/*
void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中
的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定index位置的元素，并返回此元素
Object set(int index, Object ele):设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置左闭右开的子集合

总结：常用方法
增：add(Object obj)
删：remove(int index) / remove(Object obj)
改：set(int index , Object obj)
查：get(int index)
插：add(int index, Object obj)
长度：size()
遍历：1.Iterator迭代器  2.增强for循环  3.普通循环


 */
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aa");
        list.add(new Person("Tom",20));
        list.add(456);
        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,321);
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());

        System.out.println(list.get(2));

        list.set(2,0);
        System.out.println(list);

    }


    @Test
    public void test1(){
        //面试题
        List list = new  ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        updateList(list);
        System.out.println(list);
        System.out.println(list.hashCode());

    }



    public static void updateList(List list1){
        System.out.println(list1.hashCode());
        list1.remove(1);
    }


}
