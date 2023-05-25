package class01;
import java.util.Random;
import java.util.Scanner;

/*
★ //못풀면 복습 안되어있음
1. 369 게임
9짝 33짝짝 939 짝짝짝
1~1000 중에서 랜덤으로 정수 1개 생성
[19] : 짝 입력
정답입니다!
[19] : 19
오답입니다 ...
[22] : 22
정답입니다!
 */
public class Test06Q1_2 {
	public static void main(String[] args) {
		// 1~1000중의 랜덤 정수 1개 생성
		// 랜덤 정수 1개 저장 (변수)
		// 랜덤 정수 출력 하고 [num]
		// 3,6,9,중 하나도 없으면 해당 정수를 입력 해야 함
		// 3,6,9 중 아무거나 하나당 짝 한번
		// '짝' '짝짝' '짝짝짝' 입력 받아야함
		// 그럼 사용자 답을 문자열?
		// 문자열 답을 입력 받고 int로 바꿔?
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int num = rand.nextInt(1000)+1; //랜덤정수 저장 1~1000
		System.out.print("[");
		System.out.print(num);
		System.out.println("] : ");

		String numStr = Integer.toString(num);

		int cnt = 0;
		//  - 정수가 3,6,9,중 하나 포함
		//  - ex : 867 --> 8 6 7 다 쪼개서 3,6,9 면 count 1? 
		for(int i=0; i<numStr.length();i++) {
			if (numStr.charAt(i) == '3'||numStr.charAt(i) == '6' || numStr.charAt(i) == '9') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		System.out.println("답 입력 : ");
		String userAns = sc.next(); //사용자의 정답 받을 변수
		
		// 랜덤값이 3,6,9,중 하나도 없으면 정수를 입력 해야 함
		if(cnt == 0) { //랜덤값과 같은 정수를 입력 해야함
			if(userAns.equals(numStr)) {
				System.out.println("정답입니다");
			} else System.out.println("오답입니다");
		} 
		else if (cnt == 1) {
			if(userAns.equals("짝")) {
				System.out.println("정답입니다");
			} else System.out.println("오답입니다");
		} 
		else if(cnt == 2) {
			if(userAns.equals("짝짝")) {
				System.out.println("정답입니다");
			}else System.out.println("오답입니다");
		}
		else if(cnt ==3) {
			if(userAns.equals("짝짝짝")) {
				System.out.println("정답입니다");
			}else System.out.println("오답입니다");
		}
	}
}

