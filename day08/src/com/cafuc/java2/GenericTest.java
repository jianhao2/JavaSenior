package com.cafuc.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 *      类A  是 类B的父类，G<A> 和 G<B>不具有子父类关系，二者比列关系
 *
 *      类A 是 类B的父类，A<G> 是 B<G> 的父类
 *
 * 2.通配符的使用
 *
 *
 * @author jh
 * @create 2021-08-25 15:35
 */
public class GenericTest {
    /*
     1.泛型在继承方面的体现
     */
    @Test
    public void test(){
         Object obj = null;
         String str = null;
         obj = str;


         Object[] arr1 = null;
         String[] arr2 = null;
         arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1 和 list2不具有子父类的关系
//        list1 = list2   x
    }

    @Test
    public void test1(){
        AbstractList<String> list1 = null;
        ArrayList<String> list2 = null;
        AbstractList<String> list3 = null;
        list1 = list2;
        list3 = list2;
    }

    /*
    2.通配符的使用
        通配符：？
        类A  是 类B的父类，G<A> 和 G<B>不具有子父类关系，二者的共同父类是G<?>

     */
    @Test
    public void test2(){
//        List<Object>  list1 = null;
//        List<String>  list2 = null;
        List<?> list = null;
//        list = list1;
//        list = list2;

        //
        List<String> list3 = new ArrayList<>();
        list3.add("aa");
        list3.add("bb");
        list3.add("cc");
        list = list3;

        //添加: 对于List<?>就不能想起内部添加数据。
        //除了添加null之外
        list.add(null);

        //获取(读取)：允许读取，读取的数据类型为Object
        Object obj = list.get(0);
        System.out.println(obj);

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用
        ? extends Person:   G<? extends A> 可以作为G<A> 和 G<B>的父类，其中B是A的子类
        ? super Person:     G<? super A> 可以作为G<A> 和 G<B>的父类，其中B是A的父类
     */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;   //extends <=   (-∞，person]
        List<? super Person> list2 = null;     // super >=      [person, -∞）
        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object>  list5 = new ArrayList<Object>();

        Student student = list3.get(0);



        list1 = list3;
        Person person = list1.get(0);

        list1 = list4;
        Person person1 = list1.get(0);
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        Object object = list2.get(0);  //只能写Object

        list2 = list5;
        Object object1 = list2.get(0);

        //写入数据
//        list1.add(new Person());  X


    }
}
