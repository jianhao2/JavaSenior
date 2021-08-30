package com.atcafuc.java2;

import org.junit.Test;

/**
 * @author jh
 * @create 2021-08-23 10:29
 */
public class t1 {
    @Test
    public void test(){
        new a().jian();
    }



}

class a{
    public void jian(){
        int a = 14;
        int b = 12;
        if(a<b){
            System.out.println(b-a);
        }else{
            throw new RuntimeException("a比b大");
        }

    }}
