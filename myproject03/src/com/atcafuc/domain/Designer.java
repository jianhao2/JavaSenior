package com.atcafuc.domain;

public class Designer extends Programmer {
	private double bonus; //奖学金

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	//"12", "5", "雷军", "28", "10000", "5000"
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "\t设计师\t" + getStatus() + "\t" + 
				bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam(){
		return getMemberId() + " / " + getId() + "\t" + getName() + "\t" + 
				getAge() + "\t" + getSalary() + "\t设计师\t" + bonus ;	
	}
} 
