package com.atcafuc.service;
/**
 *  
 */



import com.atcafuc.domain.Archtect;
import com.atcafuc.domain.Designer;
import com.atcafuc.domain.Employee;
import com.atcafuc.domain.Equipment;
import com.atcafuc.domain.NoteBook;
import com.atcafuc.domain.PC;
import com.atcafuc.domain.Printer;
import com.atcafuc.domain.Programmer;

public class NameListService {
	private Employee[] employees;

	
	/**
	 * 给employees及其元素进行  初始化
	 * 
	 */
	public NameListService(){
		employees = new Employee[Data.EMPLOYEES.length];
		for(int i=0;i<employees.length;i++){
			
			//获取员工的类型
			int  type = Integer.valueOf(Data.EMPLOYEES[i][0]);
			
			//获取Employee的4个基本属性
			int id =  Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age =  Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.valueOf(Data.EMPLOYEES[i][4]);	 
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type){
			case Data.EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
				
			case Data.PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
				
			case Data.DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.valueOf(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus); 
				break;
				
			case Data.ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.valueOf(Data.EMPLOYEES[i][5]);
				stock = Integer.valueOf(Data.EMPLOYEES[i][6]);
				employees[i] = new Archtect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
		
	};


	private Equipment createEquipment(int index) {
		// TODO Auto-generated method stub
		int type = Integer.valueOf(Data.EQUIPMENTS[index][0]);
	
		switch(type){
		case Data.PC:
			return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
		
		case Data.PRINTER:
			return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
		
		case Data.NOTEBOOK:
			return new NoteBook(Data.EQUIPMENTS[index][1], Double.valueOf(Data.EQUIPMENTS[index][2]));
		
		}
		return null;
	}

	
	/**
	 * 
	* @Description ：获取当前所有员工。返回：包含所有员工对象的数组
	* @author jh
	* @date 2021年8月5日上午10:09:37
	* @return
	 */
	public Employee[] getAllEmployee(){
		return employees;
	}
	
	public Employee getEmplpoyee(int id) throws TeamException{
		for(int i=0;i<employees.length;i++){
		if(employees[i].getId()==id){
			return employees[i];
		}
		}
		throw new TeamException("找不到指定员工");

	}
	
}
