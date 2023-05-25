package class01;

import java.util.Random;

// 한글코딩,,,,,제발....
/*
 * 
 */
class Student { //순서대로 할거임
	//멤버변수 
	String name;
	int[] score;
	double avg;
	char grade;
	
	Student(String name) { //인자가 많은 애만 남겨두고 여기서 호출
		this(name,2);
	}
	Student(String name, int cnt) {
		Random rand = new Random();
		this.name=name;
		this.score=new int[cnt];
		this.makeScore();
		System.out.println(this.name+"는 시험을 "+this.score.length+"번 봅니다.");
	}
	void makeScore() {
		Random rand = new Random();
		int sum=0;
		for(int i=0;i<score.length;i++) {
			this.score[i]=rand.nextInt(101);
			sum+=this.score[i];
		} // 총합 / 시험횟수;  배열 총합이면 배열 총합을 적어주는게 가독성이 좋은 배려임
		this.avg=sum*1.0/this.score.length;//(cnt)들어가도됨<<== 한번더 생각하게됨 cnt가 왜 들어갔지?			
		this.grade='C'; //등급
		if(this.avg>=80.0) {
			this.grade='A';
		}
		else if(this.avg>=60.0) {
			this.grade='B';
		}
	}
	void printInfo() {
		System.out.println(this.name);
		for(int i=0; i<this.score.length;i++) {
			System.out.println((i+1)+"번 시험 "+this.score[i]+"점");
		}
		System.out.println("평균 "+this.avg+"점 ["+this.grade+"]"); //데이터에 담아놓지 않을 가능성이 높음
	}
	void test() {
		this.makeScore();
		System.out.println(this.name+"가 재시험을 봅니다.");
	}
}

public class HW02Answer {
	public static void main(String[] args) {
		Student s1=new Student("럭스");
		Student s2=new Student("유미",4);
		
		s1.printInfo();
		s2.printInfo();
		s2.test();
		s2.printInfo();
	}
}
