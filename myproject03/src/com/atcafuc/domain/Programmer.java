package com.atcafuc.domain;

import com.atcafuc.service.Status;

public class Programmer extends Employee{
	private int memberId;
	private Status status = Status.FREE; 
	private Equipment equipment;
	public Programmer() {
		super();
	}
	public Programmer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	//"11", "3", "李彦宏", "23", "7000"
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription(); 
	}
	
	
	public String getDetailsForTeam(){
		return memberId + " / " + getId() + "\t" + getName() + "\t" + 
				getAge() + "\t" + getSalary() + "\t" + "程序员";	
	}
	
}
