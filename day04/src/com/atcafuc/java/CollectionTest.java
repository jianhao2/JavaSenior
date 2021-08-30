package com.atcafuc.java;

import org.junit.Test;

/**
 * 1.集合、数组是对多个数据进行存储操作的结构、简称java容器
 *   说明：此时的存储，主要是指内存层面的存储，不涉及持久化存储（.txt .jpg .avi）
 *
 * 2.1 数组在存储多个数据的特点
 *      >一旦定义好，其长度也就去确定了
 *      》数据一旦定义好，其元素的类型也就确定了。比如：String[] str , int[]  arr, Object[] arr2;
 * 2.2 数组在存储数据方面的缺点
 *          》 一旦初始化后，长度不可修改
 *          》 数组中提供的方法有限，添加、删除、插入数据等操作不方便，效率不高。
 *          》获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *          》数组存储数据的特点：有序、可重复。  对于无序、不可重复的需求，不能满足。
 *
 * 3.集合框架
 *      |-----Collection接口：单列集合，用来存储一个一个的对象
 *          |---List接口:存储有序的、可重复的数据    ----》动态数组
 *              |---ArrayList、LinkedList、Vector
 *
 *         |---Set接口：存储无序的、不可重复的数据   可用来做数据过滤
 *              |---HashSet、LinkedHashSet、TreeSet
 *
 *     |---Map接口：双列集合，用来存储一对（key - value）数据
 *         |---HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * Collection
 *
 * @author jh
 * @create 2021-08-20 16:10
 */
public class CollectionTest {

@Test
    public void test(){}


}

