package day5;

class Employee {
 	int id;
 	String name;
 	int baseSalary;
 	int generalFee;
 	int totalSalary;
 	
 	public Employee(int id, String name, int baseSalary, int generalFee) {
		//super();
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
		this.generalFee = generalFee;
	}
	public void calcTotalSalary() {
 		totalSalary = baseSalary + generalFee;
 	}
}

class Manager extends Employee{
	int manFee;

	public Manager(int id, String name, int baseSalary, int generalFee, int manFee) {
		super(id, name, baseSalary, generalFee);
		this.manFee = manFee;
	}

	public void calcTotalSalary() {
		//totalSalary = baseSalary + generalFee + manFee;
		super.calcTotalSalary(); //totalSalary = baseSalary + generalFee
		totalSalary = totalSalary + manFee;
	}
 }
	
class Engineer extends Employee{
	int certiFee;
	int techFee;
	Engineer(int id, String name, int baseSalary, int generalFee,
			int certiFee, int techFee){
		super(id, name, baseSalary, generalFee);
		this.certiFee = certiFee;
		this.techFee = techFee;
	}

	public void calcTotalSalary() {
		totalSalary = baseSalary + generalFee + certiFee + techFee;
	}
}
class Secretary extends Employee{
	int secFee;
	public Secretary(int id, String name, int baseSalary, int generalFee
			, int secFee) {
		super(id, name, baseSalary, generalFee);
		this.secFee = secFee;
	}

	public void calcTotalSalary() {
		totalSalary = baseSalary + generalFee + secFee;
	}
		
	}

//====== 4개 클래스 정의 ================
	   
class SalaryTest{
public static void main(String args[]){

	Employee e [] = new Employee[4];
	// 1.상속 2.생성자(타입 순서 갯수....)
	e[0] = new Employee
	(1000,"이사원",10000,5000);
	e[1] = new Manager
	(2000,"김간부",20000,10000,10000);
	e[2] = new Engineer
	(3000,"박기술",15000,7500,5000,5000);
	e[3] = new Secretary
	(4000,"최비서",15000,7000,10000);

	System.out.println("사번  :  이름   :   본봉   :  총급여");
	for(int i = 0; i < e.length; i++) {
		e[i].calcTotalSalary();
		// e[i] 자동형변환 이후에  e[i].overriding메소드() - 객체마다 포함
		//e[i] 자동형변환 이후에  e[i].멤버변수 - Employee  클래스 선언
		System.out.println
		(e[i].id+":"+e[i].name+":"
		+e[i].baseSalary+":"+e[i].totalSalary);
		//Engineer  객체인 경우에는 certiFee, techFee   같이 출력
		//5분
		if(e[i] instanceof Engineer) {// i=2 - true
				//Engineer en = (Engineer)e[i];
				System.out.println
				(((Engineer)e[i]).certiFee+":"+((Engineer)e[i]).techFee);	
				
		}
	}
	//e -  배열
	//e[i] - Employee 1개

	
			
	/* 배열 내의 각 객체의 
          급여계산메소드 호출하고
	사번, 이름, 총급여 출력

사번:이름:본봉:총급여
1000:이사원:10000:xxxxx
2000:김간부:20000:xxxxx
3000:박기술:15000:xxxxx
4000:최비서:15000:xxxxx
 */ 
	}
}	

