package class01;

import java.util.Random;

// 메소드 시그니처 (설계 할때 매우 중요함; 회사들은 설계 잘하는 사람을 뽑음; 설계대로 코딩하는건 다 함; 설계를 하는건 쉽지않음)
// 메소드(함수)의 3요소
// 1.input 2.output 3.기능
// public static int makeRandNum(int start, int end) <<<== 메소드시크니처; 설계서에 이거 한줄 올라옴
// 				: start부터 end까지의 범위에서 난수를 생성 해 주세요
// 

public class Test02MethodSignatureReview {
	
	// 함수 제작 방법 1)
	// 메소드 시그니처 먼저 정의하고, 
	// 내부 기능을 구현하는 방법
	
	// 시작 범위부터 ~ 끝 범위까지 중에서 (만드려는 기능음 보고) 
	// 랜덤으로 정수 1개를 출력해주세요! (출력 --->> 반환값 없음 --->> output 없음)
	// input: int start, int end -> int x2(두개)
	// start, end보다 left, right && low, high를 많이 씀 
	// output: X(void)
	public static void printRandNum(int start, int end) { // methodSignature를 먼저 만들고 
		Random rand = new Random();
		int randNum = rand.nextInt(end-start+1)+start;
		System.out.println("랜덤수: " + randNum);
	}
	// 함수 제작 방법 2)
	// 내부 기능을 가져오고,
	// 가져온 그 기능에 맞게 메서드 시그니처를 작성하는 방법 
	public static int makeRandNum(int start, int end) {
		Random rand = new Random();
//		int start = 10; //하드코딩 ㄴㄴ 외부에서 받아와야 함
//		int end = 20;	// 하드코딩 ㄴㄴ 외부에서 받아와야 함
		int randNum = rand.nextInt(end-start+1)+start;
		return randNum; //<<--반환이 있으면 output 자리에 자료형 바꿔줘야함
	}
	
	public static void main(String[] args) {
		
		/// 함수제작방법2) 이미 잘 만들어져있었던 기능을 뜯어감
		int randNum = makeRandNum(10,20); //<<=== 반환이 있었어야 함
		System.out.println("랜덤수: " + randNum); // <<--- 메인에서 작동 하려면 선언 메인에서
		
		
		
	}
}
