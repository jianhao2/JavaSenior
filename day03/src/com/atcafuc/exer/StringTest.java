package com.atcafuc.exer;

/**
 * @author jh
 * @create 2021-08-11 17:06
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'a','b','c','d'};

    public void change(String str,char[] ch){
        str = "best";
        System.out.println(str);
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        StringTest st1 = new StringTest();
        st1.change(st1.str,st1.ch);
        System.out.println(st1.str);
        System.out.println(st1.ch);

    }

}
