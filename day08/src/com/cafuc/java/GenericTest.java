package com.cafuc.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk5.0新增的特性
 *
 * 2.在集合中使用泛型：
 * 总结：
 *      2.1-集合接口或集合类在jdk5.0时都修改为但泛型的结构。
 *      2.2-在实例化集合类时，可以指明具体的泛型类型
 *      2.3-指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(方法，构造器，属性等等)使用到类的泛型的位置，
 *          都指定为实例化的泛型类型.
 *          比如：add(E e)--->实例化以后  add(Integer e)
 *      2.4-注意点：泛型的类型必须是类
 *      2.5-如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 * 3.如何自定义范型结构：泛型类、泛型接口；泛型方法. 见 GenericTest1.java
 *
 * 注意：
 *  1.静态方法不能使用类的泛型
 *  2.异常类不能是泛型类
 *
 * @author jh
 * @create 2021-08-25 12:01
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test() {
        ArrayList list = new ArrayList();
        //需求：存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //问题一：类型不安全
        list.add("abc");

        for (Object obj : list) {
            //问题二：强转时，可能出现ClassCastException
            int score = (int) obj;
            System.out.println(score);

        }
    }

    @Test
    public void test1() {
        //jdk7 新特性 ：类型推断
        ArrayList<Integer> list = new ArrayList<>();
        list.add(66);
        list.add(75);
        list.add(79);
        list.add(84);

        //编译时，会进行类型检查，保证数据的安全
//        list.add("tom");

        //遍历
//        for(Integer score : list){
//            //避免了强转操作
//            System.out.println(score);
//        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int score = iterator.next();

            System.out.println(score);
        }

    }

    //在集合中使用泛型的情况，以HashMap为例
    @Test
    public void test2(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom",80);
        map.put("Jack",78);
        map.put("Mike",85);
        //
//        map.put(12,12);

        Set<Map.Entry<String,Integer>> entry =  map.entrySet();   //Entry是Map的内部接口
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String name = next.getKey();
            int score = next.getValue();
            System.out.println(name + "--" + score);
        }


    }


}
