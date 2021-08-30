package com.atcafuc.java;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jh
 * @create 2021-08-24 15:28
 */
public class TreeMapTest {
    //向TreeMap中添加key-value,要求key必须是同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    //
    @Test
    public void test(){
        TreeMap treeMap = new TreeMap();
        Person1 p1 = new Person1("Tom", 23);
        Person1 p2 = new Person1("Jerry", 32);
        Person1 p3 = new Person1("Jack", 20);
        Person1 p4 = new Person1("Jack", 10);
        Person1 p5 = new Person1("Rose", 18);
        treeMap.put(p1,98);
        treeMap.put(p2,89);
        treeMap.put(p3,77);
        treeMap.put(p4,90);
        treeMap.put(p5,90);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"---"+entry.getValue());

        }

    }

}
