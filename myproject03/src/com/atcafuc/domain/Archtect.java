package com.atcafuc.domain;

public class Archtect extends Designer {

	private int stock;

	public Archtect() {
		super();
	}

	public Archtect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}  
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "\t设计师\t" + getStatus() + "\t" + 
				getBonus() +"\t"+ stock + "\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam(){
		return getMemberId() + " / " + getId() + "\t" + getName() + "\t" + 
				getAge() + "\t" + getSalary() + "\t架构师\t" + getBonus() + stock ;	
	}
	
}
