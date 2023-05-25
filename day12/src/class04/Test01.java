package class04;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//PK가 있는 이유는 홍길동이라는 이름을 가진 학생이 두명이상이 있을수 있기 때문입니다
class Student {
	private int num; //PK
	private String name;
	private int score;
	Student(int num, String name) {
		this.num=num;
		this.name=name;
		Random rand = new Random();
		this.score=rand.nextInt(101);
	}
	void test() {
		Random rand = new Random();
		this.score = rand.nextInt(101);
		System.out.println(this.name+"학생은 " + this.score + "점입니다");
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return this.num+"번 학생 "+ this.name+" "+this.score+"점";
	}
}
public class Test01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> data = new ArrayList<Student>();
		int numPK=1001; // 프로그램이 부여 하는 방식 : 1001번부터 순서대로 부여; 우리는 사용자에게 입력 받지 않을것임; 
		//PK를 "사용자"로부터 입력받는경우, 반드시 중복검사를 해야함
		//        =>> 안정성문제가 일어날 수 있음. 
		//ex) ID
		while(true) {
			System.out.println("1. 학생목록출력");
			System.out.println("2. 제시험보기");
			System.out.println("3. 학생추가");
			System.out.println("4. 학생삭제");
			System.out.println("5. 프로그램종료");
			System.out.println("입력 : ");
			int action=sc.nextInt();
			
			if(action==1) {
	            for(Student student:data) {
	                System.out.println(student);//toString오버라이딩 출력해서 우리가 원하는데로 나와야함
	             }
			}
			else if(action==2) {
				System.out.println("학생번호입력 : ");
				int num=sc.nextInt();
				for(int i=0;i<data.size();i++) {
					if(num==data.get(i).getNum()) {
						data.get(i).test();
						break; //학생이 100만명이면 
					}
				}
			}
			else if(action==3) {
				System.out.println("학생이름 입력 : ");
				String name=sc.next();
		        data.add(new Student(numPK++,name));
			}
			else if(action==4) {
				System.out.println("학생번호입력 : "); //이름 입력 받으면 똑같은이름 가진 학생이 삭제될 수도 있음
				int num=sc.nextInt();
				for(int i=0;i<data.size();i++) {
					       //배열에있는.학생의.번호
					if(num == data.get(i).getNum()) { //num와 번호가같은학생이있니?
						data.remove(i);
						break; // 삭제를 해도 해당 학생번호는 보존 해 줘야함.
					}
				}
			}
			else break;
			
			
		}
	
	
	}
	
	
}
