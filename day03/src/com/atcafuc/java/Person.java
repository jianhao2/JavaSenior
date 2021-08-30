package com.atcafuc.java;

/**
 * @author jh
 * @create 2021-08-11 16:24
 */
public class Person {
    String name;
    int age;
    String name1;

    public Person() {
    }

    public Person(String name, String name1,int age) {
        this.name = name;
        this.age = age;
        this.name1 = new String(name1);
    }
}
