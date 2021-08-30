package com.atcafuc.java;

/**
 * @author jh
 * @create 2021-08-23 12:25
 */
public class Person1 implements Comparable {


    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person1() {
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println("Person.equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person1 person = (Person1) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小排列,年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person1){
            Person1 P = (Person1) o;
//            return this.name.compareTo(P.name);
            int compare = this.name.compareTo(P.name);
            if(compare != 0 ){
                return -compare;
            }else{
                return Integer.compare(this.age, P.age);
            }

        }else{
            throw new RuntimeException("数据类型不匹配。");
        }
    }
}
