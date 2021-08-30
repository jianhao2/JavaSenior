package com.cafuc.java;

import java.io.Serializable;

/**
 *Person需要满足
 *
 * @author jh
 * @create 2021-08-27 13:03
 */
public class Person  implements Serializable {  //Serializable 标识接口
    public static final long serialVersionUID = 41L;
    private String name;
    private int age;
    private int id = 20;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
