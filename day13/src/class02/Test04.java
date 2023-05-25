package class02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
☆ 어떤 컬렉션을 사용해야할까?
	ArrayList : 중복 허가, 정렬할수있음 
				10개에서 나중에 제거 해야 함 
	HashSet : 중복안됨, 인덱스 없음
	배열 : 길이 한번 정하면 변경 불가 -->> 제거가 안됨 
	
☆ 한글코딩시 어떤 제어문을 사용해야할까?
	제어문 : 조건문, 반복문
			if    while, for
	
☆ 사용자가 잘못된 입력을 하면 어떻게 해야할까?

=======================[ 문제 ] ===================

정수를 입력; 10개 될때까지 계속 --->>>> while 
								 종료조건 if
								  
입력한 정수들을 모두 출력 --->>>>		 for each
[ 1, 3, -1, 0, 10, ... ]

이중에서 0이하인 정수들을 모두 제거하고 출력
[ 1, 3, 10, ... ]

이중에서 가장 큰 정수가 저장된 인덱스 넘버 출력
	[2]번
가장 큰 정수를 제외하고 남은 정수들의 합과 평균 출력
	4	2.0

 */
//===================
/*
Scanner sc = new Scanner
ArrayList :  중복 허가, size 
				● 10개에서 나중에 제거 해야 함 
제네릭 Integer 정수만 입력 
ArrayList<Integer> data = new ArrayList<>();
● 정수를 입력 10개가 될때까지 계속 --->>>> while 
입력받으려면 스캐너 선언, import 				
	
	int cnt=0; 
	while(cnt<10) { 입력된 값의 개수가 10미만이면 계속계속계속 입력 
		정수만 입력 다른 값 예외처리
		try { 
			System.out.println("정수입력 : ");
			정수 변수 = sc.nextInt 입력 
			System.out.println( (cnt+1)+"번째 정수 = "+num );
			data리스트.add(num)
			cnt++;
			
		} catch (InputMisMatch){ 
		
			sc.nextLine();
			System.out.println("정수로만 입력 해 주새요");
			
		} 
	}
								  
● 입력한 정수들을 모두 출력 --->>>>		 for each
[ 1, 3, -1, 0, 10, ... ]


for(int v : data) {
	syso(v);

}

● 이중에서 0이하인 정수들을 모두 제거하고 출력 
[ 1, 3, 10, ... ]
	-->> 
		삭제한 인덱스부터 재확인!==>> 언제 검사가 완료 될지 모른다 ==>> while() , 
		만약 삭제 해야 하는 값이 발견 되면 증감 ㄴㄴ
		
int index = 0; 
while(index<data.size()) {
	if(data.get(index)<=0) {데이타리스트의 해당 인덱스에 있는 값이 만약 0이하라면 
		data.remove(리스트의 인데스 삭제);
		그리고 증감 방지; continue
	}
	그게 아니면 증감 해도됨 index++; 다음인덱스에 있는 값을 확인 
}	

● 이중에서 가장 큰 정수가 저장된 "인덱스 넘버" 출력
	[2]번
	정수 가장큰수변수=데이타리스트.get(0)번째 인덱스 값부터 넣고 다음을 차례로 비교 
	for문(int i=1;i<data.size();i++ {
		만약 가장큰수변수안에 저장된 데이타리스트의 가장 첫번째 값이 다음 값보다 작다면
		다음 값을 새로운 가장큰변수에 덮어씌움
	}
	가장 큰 수는 syso ("가장 큰 수는 " + 가장큰수변수)
	
	syso("가장 큰 수를 담고 있는 인덱스는 "+ data.indexOf(가장큰수))
	
● 가장 큰 정수를 제외하고 남은 정수들의 합과 평균 출력
	4	2.0
	
	총합
	총합변수 = 0;
	for each
	for(int v = data) {
		총합변수 +=v; 누적합 
	}
	더블 평균변수 = (총합변수 * 1.0 )/data.size();
	
	출력(총합변수, 평균변수)
	

*/

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<>();
		
		/*
 ● 정수를 입력 10개가 될때까지 계속 --->>>> while 		
		 */

		int cnt=0; 
		while(cnt<10) { //입력된 값의 개수가 10미만이면 계속계속계속 입력 
			int num; //scope 이슈
			try { //정수만 입력 다른 값 예외처리
				System.out.print("정수입력 : ");
				num = sc.nextInt();
				System.out.println( (cnt+1)+"번째 정수 = "+num );
				data.add(num);
				cnt++;
			} catch (InputMismatchException e){ 
				sc.nextLine();
				System.out.println("정수로만 입력 해 주새요");
			} 
		}
		/*
● 입력한 정수들을 모두 출력 --->>>>		 for each
[ 1, 3, -1, 0, 10, ... ]
		 */
		System.out.println(data);
/*
● 이중에서 0이하인 정수들을 모두 제거하고 출력 
[ 1, 3, 10, ... ]	삭제한 인덱스부터 재확인!==>> 언제 검사가 완료 될지 모른다 ==>> while() , 
					만약 삭제 해야 하는 값이 발견 되면 증감 ㄴㄴ
 */
		int index = 0; 
		while(index<data.size()) {
			if(data.get(index)<=0) {//데이타리스트의 해당 인덱스에 있는 값이 만약 0이하라면 
				data.remove(index);//리스트의 인데스 삭제
				continue; //그리고 증감 방지;
			}
			index++; //그게 아니면 증감 해도됨 다음인덱스에 있는 값을 확인 
		}	

//		System.out.print("[ ");
//		for(int v : data) {
//			System.out.print(v+" ");
//			//System.out.print(", ");
//		}
//		System.out.println("]");
		System.out.println(data);
//● 이중에서 가장 큰 정수가 저장된 "인덱스 넘버" 출력
		
		int max=data.get(0);//0번째 인덱스 값부터 넣고 다음을 차례로 비교 
		for(int i=1;i<data.size();i++) {
			if(max<data.get(i)) {//	만약 '가장큰수변수'안에 저장된 데이타리스트의 가장 첫번째 값이 다음 값보다 작다면
				max=data.get(i); // 다음 값을 새로운 '가장큰변수'에 덮어씌움
			}
		}
		System.out.println("가장 큰 수는 : "+ max);
		System.out.println("가장 큰 수를 담고 있는 인덱스는 "+ data.indexOf(max));

/*
● 가장 큰 정수를 제외하고 남은 정수들의 합과 평균 출력
	4	2.0
 */
		//총합
		data.remove(data.indexOf(max)); //가장 큰 수 빼야 함 
		System.out.println(data);
		
		int sum = 0;
		for(int v : data) {
			sum += v; //누적합 
		}
		double avg = (sum * 1.0 )/data.size();
		
		System.out.println("총합 : " + sum + " , 평균 : " + avg);


		
		
		
	}
}
