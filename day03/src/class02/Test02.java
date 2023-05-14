package class02;

import java.util.Random; // 해당 서랍장 자동 제공 ctrl + shit + O

public class Test02 {

	public static void main(String[] args) {
		int[] stu = new int[6];
//		랜덤으로 점수를 생성해보자!
//		java.util.Random rand = new java.util.Random();
		Random rand = new Random();
		for(int i = 0; i<stu.length;i++) {
//			stu[i]=랜덤수;
//			stu[i]=rand.nextInt(랜덤수범위);
			stu[i]=rand.nextInt(101); // 0~100까지
			
			System.out.print(stu[i]+" ");
		}
		
		// 1. 평균점수
		int sum=0; //총점을 저장할 변수
		for(int i=0; i<stu.length;i++) {
			sum+=stu[i];
		}
		double avg = sum*1.0/stu.length;
		System.out.println("평균:" +avg);
		
		// 2. 평균을 넘긴 학생 수 
		// 5. 평균을 못넘긴 학생들의 번호 --->> XXX 변수로 만들수가 없어요
		//		: 저장공간을 예상하는 방법 (리스크 : 저장공간은 모두 돈이다)
		//		: 나중에 배열을 생성하는 방법
		int num=0; //평균넘긴학생수를 저장할 변수
		for(int i=0;i<stu.length;i++) {
//			if(내가 보고있는 학생이 평균을 넘겼어?) {
//				num++;
//			}
			if(stu[i] >=avg) {//[내가보고있는학생]이평균을 넘겼어?
				num++;
			}
			else {
				System.out.println((i+1)+"번은 평균점수 이하 입니다.");
			}
		}
		System.out.println("평균점수이상을 받은 학생수는 " +num+"명");
		
		// 3. 6등의 번호 
		// -->> [최대값찾기 알고리즘] 활용
		
		int min = stu[0];
		int minIndex=0;
		for(int i=1;i<stu.length;i++) {
			if(min>stu[i]) { //너 최저값보다 작아? 그럼 바꿔야지
				
				min = stu[i];
				minIndex=i;
			}
		}
		System.out.println("6등은 " + (minIndex+1)+"번입니다.");
	
		// 4. 짝수번째 학생들의 총점
		int res=0;
		for(int i=0;i<stu.length;i++) {
//			if(stu[i]가 짝수번째니?) {
			if(i%2==1) {
				res+=stu[i];
			}
		}
		System.out.println("짝수번째 학생들의 총점은 " +res+ "점입니다");
	}
}
