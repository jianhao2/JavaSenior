package com.cafuc.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 *
 * @author jh
 * @create 2021-08-24 10:32
 */
public class EmployeeTest {

    //问题一：
    @Test
    public void test() {

//        Comparator com = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee e1 = (Employee) o1;
//                    Employee e2 = (Employee) o2;
//                    MyDate b1 = e1.getBirthday();
//                    MyDate b2 = e2.getBirthday();
////                    int minusYear = b1.getYear() - b2.getYear();
////                    if (minusYear != 0) {
////                        return minusYear;
////                    }
////
////                    int minusMonth = b1.getMonth() - b2.getMonth();
////                    if (minusMonth != 0) {
////                        return minusMonth;
////                    }
////
////                    return b1.getDay() - b2.getDay();
////
////                }
////
////                throw new RuntimeException("数据类型不批配。");
//                return b1.compareTo(b2);
//            }
//                throw new RuntimeException("传入数据类型不一致");
//            }
//        };


        //使用泛型后的写法
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                return b1.compareTo(b2);
            }
        };

        TreeSet<Employee> treeSet =  new TreeSet(com);
//        TreeSet treeSet = new TreeSet(com);
        Employee e1 = new Employee("liudehua", 55, new MyDate(1964, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofengcheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);
        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }

//        HashSet hashSet = new HashSet();

    }
}
