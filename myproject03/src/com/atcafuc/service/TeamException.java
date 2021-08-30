package com.atcafuc.service;

/*
 * 如何自定义异常类？
 * 1.继承于现有的异常结构：RuntimeException、Exception
 * 2.提供全局常量：serialVersionUID
 * 3.提供重载构造器
 * 
 * 
 */

public class TeamException extends Exception {

	    static final long serialVersionUID = -7034897190745739L;
	    public TeamException(){}
	    
	    public TeamException(String msg){
	    	super(msg); 
	    }

	}


