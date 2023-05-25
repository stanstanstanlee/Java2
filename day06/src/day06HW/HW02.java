package day06HW;

import java.util.Random;

/*
"학생" 만들어줭
class Student
   String name
   int[] score
   double avg
   char grade
Student student=new Student("럭스");
   럭스는 시험을 2번 봅니다.
Student student=new Student("유미",4);
   유미는 시험을 4번 봅니다.
시험점수는 0~100 랜덤으로 저장
student.printInfo();
   럭스
   1번 시험 100점
   2번 시험 50점
   평균 75.0점 [B]
    80.0점이상 A
    60.0점이상 B
    나머지 C
   유미
   1번 시험 100점
   2번 시험 50점
   3번 시험 1점
   4번 시험 21점
   평균 43.0점 [C]

student.test();
   럭스가 재시험을 봅니다.
   score[]배열에 저장된 시험점수(0~100)값을 랜덤으로 다시 저장합니다.
 */
class Student {
	//멤버변수
	String name;
	int[] score; // 시험점수는 0~100 랜덤으로 저장
	double avg;
	char grade;

	//생성자(오버로딩)
	Student(String name) {
		int x = 2;
		System.out.println(name+"이(가) 시험을 "+x+"번 봅니다");
	}
	Student(String name, int x) {
		System.out.println(name+"이(가) 시험을 "+x+"번 봅니다");
	}

	/*
	럭스
   1번 시험 100점
   2번 시험 50점
   평균 75.0점 [B]
    80.0점이상 A
    60.0점이상 B
    나머지 C
       유미
   1번 시험 100점
   2번 시험 50점
   3번 시험 1점
   4번 시험 21점
   평균 43.0점 [C]
	 */
	//함수(기능)
	void printInfo() {
		System.out.println(this.name);
		
	}
	
	//재시험 기능 
	//요구사항 : ㅁㅁㅁ가 재시험을 봅니다. score[]배열에 저장된 시험점수(0~100)값을 랜덤으로 다시 저장합니다.
	//INPUT : String name, 
	//OUTPUT : 
//	int[] test(String name) { 
//		
//		System.out.println(name+"가 재시험을 봅니다");
//		return;
//	}
}


public class HW02 {
	public static void main(String[] args) {
		Student stu1= new Student("럭스");
		Student stu2 = new Student("티모",4);
		
		
		
		
		
	}
}
