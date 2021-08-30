package com.atcafuc.service;
/**
 * 
 * 
* @Description 表示成员状态
* @author jh
* @version
* @date 2021年8月4日下午4:10:20
*
 */
//public class Status {
//	private final String NAME;
//	private Status(String name){
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return NAME;
//	}
//}

public enum  Status{
	FREE,BUSY,VOCATION;
}