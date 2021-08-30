package com.atcafuc.demo;

public class Demo
{
	public static void main(String[] args) {
//		C c1 = new C();
//		System.out.println(c1);
//		System.out.println(c1 instanceof C);
//		
//		B b1 = (B)c1;
//		
//		System.out.println(b1);
//		System.out.println(b1 instanceof C);
//		
//		B b2 = new B();
//		
//		System.out.println(b2);
//		System.out.println(b2 instanceof C);
		
		
		
	}
}



class A extends Demo{
	String name = "a";
}

class B extends A{
	String name = "b";
}


class C extends B{
	String name = "c";
}