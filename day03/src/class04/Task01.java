package class04;

import java.util.Random;

public class Task01 {
	public static void main(String[] args) {
		/* 주석
			1) 이 배열의 이름은 data 이고 
			2) 3~5개까지 중에서 랜덤으로 크기를 결정
				ex) 3 --->> [ _ _ _ ]
			3) data에 저장되는 정수는 100~105 사이의 랜덤수가 저장
				ex) [ 102 100 100 ]	
			4) A- 홀수들의 총합
			5) B- 짝수들의 평균 
		 */
		
		// ★ 풀이를 한국어로 작성해보자! ★
		
		/* 한글풀이
		 	1) Random을 생성
		 	2) 랜덤크기를 정할 N변수저장공간 생성
		 	3) data라는 배열을 N랜덤크기를 이용해 생성
		 	4) data에 정수 100~105의 랜덤 숫자를 저장
			5) 홀수들의 총합
			6) 짝수들의 평균
		 */
			Random rand = new Random();
			int N = rand.nextInt(3)+3; // 0 1 2 ===>>> 3 4 5
			int sum = 0;
			double avg = 0;
//			System.out.println("data배열의 랜덤크기 : " + N);
			
			int data[] = new int[N];
			int flag = 0;
			//랜덤크기 배열에 100~105 랜덤숫자 대입
			for(int i = 0; i<data.length; i++) {
				data[i] = rand.nextInt(6)+100;
				
			}
			
			//중복 제거
			//???
			
			// 배열 출력 [ _ _ _ _ _ ]
			System.out.print("[ ");
			for(int v : data) {
				System.out.print(v + " ");
			}
			System.out.println(" ]");
			
			//홀수 총합
			for(int v : data) {
				if(v %2==1) {
					sum+=v;
				}
			}
			System.out.println("홀수총합 : " + sum);
			
			//짝수 평균
			int count = 0;
			int sum2 = 0;
			for(int v : data) {
				if(v %2 == 0) {
					sum2+=v;
					count++;
				}
			}
			avg = (sum2*1.0)/count;
			System.out.println("짝수평균 : " + avg);
	}
}
