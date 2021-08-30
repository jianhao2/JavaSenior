package com.atcafuc.service;

import com.atcafuc.domain.Archtect;
import com.atcafuc.domain.Designer;
import com.atcafuc.domain.Employee;
import com.atcafuc.domain.Programmer;

/**
 * 
* @Description: 关于开发团队成员的管理：添加、删除等
* @author jh
* @version
* @date 2021年8月5日上午11:17:34
*
 */
public class TeamService {
	private int counter = 1;   //给memberId赋值使用
	private final int MAX_MEMBER = 5;   //限制开发团队的人数
	private Programmer[] team = new Programmer[MAX_MEMBER]; //保存开发团队的人员
	private int total;  //记录开发团队中的实际人数   
	
	
	public TeamService() {
		super();
	}


	public Programmer[] getTeam(){
		 Programmer[] team = new Programmer[total];
		 for(int i=0;i<team.length;i++){
			 team[i] = this.team[i];
		 }
		return team;
	}
	
	
	
	
	public int getTotal() {
		return total;
	}


	/**
	 * 
	* @Description 判断指定的员工是否已经存在于现有的团队中 
	* @author jh
	* @date 2021年8月5日下午2:14:07
	* @param e
	* @return
	 */
	public boolean isExist(Employee e){
		 for(int i=0; i<total;i++){
			 return team[i].getId()==e.getId();
			 }
		 
		return false;
	}

	/**
	* @Description ：将指定 添加到开发团队中 
	* @author jh
	* @date 2021年8月5日下午1:48:45
	* @param e
	 * @throws TeamException 
	*/
	public void addMember(Employee e) throws TeamException{
		//成员已满，无法添加
		if(total>=MAX_MEMBER){
			throw new TeamException("成员已满，无法添加!");
		}
		
		//该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)){   //!
			throw new TeamException("该成员不是开发人员，无法添加");
		}   
		
		//该成员已在开发团队中
		if(isExist(e)){
			throw new TeamException("该成员已在开发团队中");
		}
		
		//该员工已是某团队的成员
		//该员工正在休假，无法添加
		Programmer p = (Programmer)e; //强转
//		if("BUSY".equals(p.getStatus().getNAME())){//if(p.getStatus().getNAME().equals("BUSY")){
//			throw new TeamException("该员工已是某团队的成员");
//		}
//		else if("VOCATION".equals(p.getStatus().getNAME())){
//			throw new TeamException("该成员已在开发团队中");
//		}
		switch(p.getStatus()){   //byte\short\char\int\String\枚举类
			case BUSY:
				throw new TeamException("该员工已是某团队的成员");
			case VOCATION:
				throw new TeamException("该成员正在休假，无法添加");
		}
		
		//获取team成员中已有的架构师，设计师，程序员人数
		int numOfArch =0,numOfPro=0, numOfDes=0;
		for(int i=0; i<total; i++){
			if(e instanceof Archtect){
				numOfArch++;
			}else if(e instanceof Designer){
				numOfDes++;
			}else if(e instanceof Programmer){
				numOfPro++;
			}
			
			if(p instanceof Archtect){
				if(numOfArch>=1){
					throw new TeamException("团队中至多有一名架构师");
				}else if(p instanceof Designer){
					if(numOfDes >= 2){
						throw new TeamException("团队中至多有二名设计师");
					}
				}else if(p instanceof Designer){
					throw new TeamException("团队中至多有三名程序员");
				}
//				
//				//错误
//				if(p instanceof Archtect && numOfArch=1){
//					throw new TeamException("团队中至多有一名架构师");
//				}
//						
			}
			
			
		}
		//将p(或 e)添加到team中
		team[total++] = p;
		
		//p的属性值
		p.setStatus(Status.BUSY); 
		p.setMemberId(counter++);	
	
	}
	
	
	//后一个元素覆盖前一个元素，实现删除操作  
	public void removeMember(int memberId) throws TeamException{
		int i = 0;	
		boolean isFind = false;
		for(;i<total; i++){
				if(team[i].getMemberId()==memberId){
					team[i].setStatus(Status.FREE);
					isFind = true;
					break;  //不执行i++
				}
		}
		
		//未找到该员工
		if(!isFind){
			 throw  new TeamException("未不到该员工，删除失败	！");
		}
		
		for(int j=i+1;j<total;j++){
			team[j-1] = team[j];
		}
		
		team[--total] = null;
	}
			
}

