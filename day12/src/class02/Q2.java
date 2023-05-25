package class02;

import java.util.ArrayList;
import java.util.Scanner;

/*
2. 정수를 입력합니다. 0을 입력하면 종료됩니다. <<종료조건
프로그램이 종료되었을때,
현재까지 입력한 정수들의 평균을 출력해주세요!~~
	__.__입니다.

입력한 정수중에서 짝수가 몇개인지 출력해주세요!~~
	짝수는 __개입니다.
	 [ _, _, _ ] 입니다.
 => 해당 컬렉션에 짝수만 남겨서 출력 해 주세요!~~

 */
//--------------------------------------------------------------
/*
정수를 입력합니다.
	Scanner 클래스를 import해줌
	
	Scanner sc = new Scanner(System.in); //스캐너 생성
	
	//배열길이 모르니까 일반 배열 못씀
	//HashSet 순서도 없고 (인덱스없음) 중복 값도 못받고 그래서 안씀
	
	ArrayList<Integer> data = new ArrayList<>();

	저장공간에 int로 사용자의 입력 값을 받음

	입력 계속 받을 수 있음 ==>> while문

	종료조건 : 0을 입력 받았을때

	종료 했을때 지금까지 입력된 모든 정수들의 평균을 출력 해야 함
			짝수의 개수도 출력 해야함 
			짝수는 ㅁ개 입니다. 
			반복문으로 data안에 있는 각 값을 매번 찾아서 카운트해야함
			even 체크 하고 아니면 remove()해야함. 

	평균 구해야 함
	평균 구하려면 모든 입력 받은 값을 저장 해야하나??? 
	int input = nextInt();
	data.add(input)???이렇게

	총합
	double sum = 0;
	이거 If 인디 
	//총합 먼저 구함
	for(int nums : data) {
		sum+=nums;
	}

	double avg = (sum / data.size());



================
while(true) {
	syso("정수를 입력해 주세요\n "
		+ 0을 입력 하시면 종료 됩니다.\n
		+ ||정수 입력 : ");

	int input = sc.nextInt()

	data.add(input)정수 저장??? 계속 함 0입력 할때 까지


	if(혹시0을입력했엉?) { // input == 0
		//총합
		double sum = 0;

		//총합 먼저 구함
		for(int nums : data) {
			sum+=nums;
		}
		//평균
		 avg = 지금까지 입력받은 숫자들 총합 나누기 정수의 개수들
		double avg = (sum / data.size());

		syso("지금까지 입력된 정수들의 평균은 " + avg +" 입니다.");

		/짝수 찾아야함
		/짝수가 몇개인지
		
		
		int cnt = 0; //짝수 찾을 때 마다 카운트 
		for(int i = 0;i<data.size();i++ {
			int even = data.get(i);
			int oddIndex = 0;
			if( even %2==0 ){//짝수면
				cnt++;카운트
			} else {
				odd 
			}
		}
		syso("짝수는 " + cnt + "개입니다" + \n
			  data + "입니다")
	}

}
 */



public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<>();
		ArrayList<Integer> oddIndex = new ArrayList<>();
		while(true){

			System.out.println("정수를 입력해 주세요\n "
					+ "0을 입력 하시면 종료 됩니다.\n"
					+ "||정수 입력 : ");

			int input = sc.nextInt(); //사용자 입력 값
			data.add(input);
			
			if(input==0) {
			
				break;
			}
		}
		data.remove(new Integer(0));
		System.out.println(data);
		//총합
		double sum = 0;

		//총합 먼저 구함
		for(int nums : data) {
			sum+=nums;
		}
		//평균
		double avg = (sum / data.size());

		System.out.println("지금까지 입력된 정수들의 평균은 " + avg +" 입니다.");
		
		//짝수 찾아야함
		
		int cnt = 0; //짝수 찾을 때 마다 카운트 
		for(int i = 0;i<data.size();i++) {

		}
		System.out.println("짝수는 " + cnt + "개입니다\n"+
			  data + "입니다");

		
	}
}
