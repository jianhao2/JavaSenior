package com.atcafuc.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明 java中的对象，正常情况下，只能进行比较：== 或 ！=。 不能使用 > 或 <
 *      但在开发过程中，需要对多个对象进行排序，可使用 Comparable or Comparator
 *
 * 二、Comparable接口与Comparator的使用对比：
 *      Comparable 接口的方式一旦确定，保证Comparable实现类的对象在任何位置都可以比较大小
 *      comparator 接口属于临时性的比较。
 *
 * @author jh
 * @create 2021-08-17 17:24
 */
public class CompareTest {


    @Test
    /*
    Comparable接口的使用举例：  自然排序
    1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式
    2.像String、包装类重写了compareTo()方法以后，进行了从小到大的排列
    3.重写compareTo的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口

     */
    public void test() {
        String str = "abcde";
        String str1 = "bcdefg";
        String[] arr = new String[]{"AA", "CC", "KK", "DD", "GG", "MM"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test1() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("amiMouse", 65);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator接口的使用：定制排序
    1.背景：
      当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
      或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用Comparator
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
      如果方法返回正整数，则表示o1大于o2；
      如果返回0，表示相等；
      返回负整数，表示o1小于o2。
     */

    @Test
    public void test2() {
        String[] arr = new String[]{"AA", "CC", "KK", "DD", "GG", "MM"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                } else {
                    throw new RuntimeException("数据类型不匹配");
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("amiMouse", 65);
        arr[5] = new Goods("huaweiMouse", 100);
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                else{
                    throw new RuntimeException("数据类型不匹配");
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods g1 = new Goods("naisjd",1234);
        Goods g2 = new Goods("hfgh",34);
        int a = new Goods().compare(g1,g2);
        System.out.println(a);
    }
}
