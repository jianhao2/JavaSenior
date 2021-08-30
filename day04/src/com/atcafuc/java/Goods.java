package com.atcafuc.java;

import java.util.Comparator;

/**
 * @author jh
 * @create 2021-08-17 17:50
 */
public class Goods implements Comparable, Comparator {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式
    @Override
    public int compareTo(Object o) {
        if(o instanceof  Goods){
        Goods o1 = (Goods) o;
        if(this.price> o1.getPrice()){
            return 1;
        }else if(this.price == o1.price){
            return this.name.compareTo(o1.name);

        }
        return -1;}
        throw new RuntimeException("传入数据类型不一致");

    }



    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof  Goods && o2 instanceof Goods){
            Goods g1 = (Goods) o1;
            Goods g2 = (Goods) o2;
            if(g1.name.equals(g2.name)){
                return -Double.compare(g1.price,g2.price);
            }else{
                return g1.name.compareTo(g2.name);
            }
        }
        else{
            throw new RuntimeException("数据类型不匹配");
        }
    }

}

