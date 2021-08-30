package com.atcafuc.java1;

import com.atcafuc.java.Person1;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author jh
 * @create 2021-08-23 21:49
 */
public class TreeSetTest {

    /*
        1.向TreeSet中添加对象，要求是相同类的对象
        2.两种排列方式:自然排序、定制排序(Comparator)
        3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
        4.定制排序中，比较两个对象

     */
    @Test
    public void test() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(123);
        treeSet.add(456);
        treeSet.add(789);
        treeSet.add(-12);
        treeSet.add(5);
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){

        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person1 && o2 instanceof Person1){
                    Person1 p1 = (Person1) o1;
                    Person1 p2 = (Person1) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else{
                    throw new RuntimeException("输入数据不匹配。");
                }
            }
        };

        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Person1("a",12));
        treeSet.add(new Person1("b",11));
        treeSet.add(new Person1("c",15));
        treeSet.add(new Person1("d",8));
        treeSet.add(new Person1("e",12));
        treeSet.add(new Person1("f",14));

        System.out.println(treeSet);
    }

}
