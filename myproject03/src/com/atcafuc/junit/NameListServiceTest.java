package com.atcafuc.junit;

import org.junit.Test;

import com.atcafuc.domain.Employee;
import com.atcafuc.service.NameListService;
import com.atcafuc.service.TeamException;

public class NameListServiceTest {
	NameListService service = new NameListService();
	
	@Test
	public void testGetAllEmployees(){
		Employee[] employees = service.getAllEmployee();
		for(int i=0;i<employees.length;i++){
		System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee(){
		try {
			Employee employees1 = service.getEmplpoyee(121);
			System.out.println(employees1.getName());
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
