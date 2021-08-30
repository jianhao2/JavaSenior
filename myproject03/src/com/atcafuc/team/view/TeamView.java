package com.atcafuc.team.view;

import com.atcafuc.domain.Employee;
import com.atcafuc.domain.Programmer;
import com.atcafuc.service.NameListService;
import com.atcafuc.service.TeamException;
import com.atcafuc.service.TeamService;

public class TeamView {


	
		
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService(); 
	
	public void enterMainMenu(){
		boolean loopFlag = true;
		char menu = 0;
		while(loopFlag){
			
			if(menu!='1'){
				listAllEmployees();
			}
			
			System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出  请选择(1-4)");
			menu = TSUtility.readMenuSelection();
			switch(menu){
			case '1':
				getTeam();
				break;
				
			case '2':
				addMember();
				break;
				
			case '3':
				deleteMember();
				break;
				
			case '4':
				System.out.println("确认是否退出(Y/N): ");
				char isExit = TSUtility.readConfirmSelection();
				if(isExit == 'Y'){
					loopFlag = false;
				}
				break;
			}
		}
		
	}
	
	/**
	* @Description 显示所有员工信息 
	* @author jh
	* @date 2021年8月5日下午3:41:24
	 */
	private void listAllEmployees(){
		System.out.println("----------------------------------------开发团队调度软件----------------------------------------\n");
		Employee[] employees = listSvc.getAllEmployee();
		if(employees==null || employees.length==0){
			System.out.println("公司没有员工信息！");
		}else{
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for(int i=0; i<employees.length;i++){
				System.out.println(employees[i].toString());
			}
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
	private void getTeam(){
//		System.out.println("查看开发团队情况");
		System.out.println("----------------------------------------团队成员列表----------------------------------------");
		Programmer[] team = teamSvc.getTeam();
		if(team==null || team.length==0){
			System.out.println("开发团队中没有成员");
		}else{
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职业\t奖金\t股票\n");
			for(int i=0;i<team.length;i++){
				System.out.println(team[i].getDetailsForTeam());
			}
		}  
	}
	
	private void addMember(){
//		System.out.println("添加团队成员");
		System.out.println("----------------------------------------添加成员----------------------------------------");
		System.out.println("请输入要添加的员工ID: ");	
		int id = TSUtility.readInt();
		try {
			 Employee emp = listSvc.getEmplpoyee(id);
			 teamSvc.addMember(emp);
			System.out.println("添加成功！");
			System.out.println("total"+teamSvc.getTotal());
			//按回车键继续

		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败，"+ e.getMessage());
		}
		TSUtility.readReturn();	
	
	}
	
	private void deleteMember(){
//		System.out.println("删除团队成员");
		System.out.println("----------------------------------------删除成员----------------------------------------");
		System.out.println("请输入要删除的员工ID: ");	
		int memberId = TSUtility.readInt();
		System.out.println("确认是否删除(Y/N)");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete=='N'){
			return;
		}else{
			try {
				teamSvc.removeMember(memberId);
				System.out.println("添加成功删除成功！");
				//按回车键继续
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				System.out.println("删除失败，原因" + e.getMessage());
			}
			TSUtility.readReturn();
		}
	}
	
	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}
	
}
