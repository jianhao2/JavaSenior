package com.atcafuc.java;

import org.junit.Test;

/**
 * @author jh
 * @create 2021-08-23 14:19
 */
public class c implements b{
    @Override
    public void method() {
        System.out.println("method");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    @Test
    public void test(){
        new c().method();
    }
}

