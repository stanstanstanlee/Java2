package class01;

import java.util.Random;
import java.util.Scanner;

// flag 알고리즘
// : 특정상황이 T인지 F인지 판단할대 활용 (어떠한 상황이 발생 했는지 안했는지 체크 할때 씀)
// : 이때 '특정상황'이 반복문, 함수, 등처럼 시간이 좀 흘러야 확인이 가능할대 
// : 범위를 모두 확인해야 알수 있을때 

public class Test01FlagAlgorithm {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] data = new int[5];
		for(int i=0; i<data.length;i++) {
			data[i]=rand.nextInt(100)+1; // 1~100
		}
		//data.length == 배열의 크기 
		//			  (저장되어있는 데이터의 개수가 아님)
		System.out.print("[");
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.println("]");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력) ");
		int num=sc.nextInt();
////=====================================flag 알고리즘=====================================
		boolean flag=false; // 전원 OFF. 배열에 num이 없는 상황을 의미
		int index = -1; //index에 없는 값으로 초기화
		
		for(int i=0; i<data.length;i++) {
			if(data[i]==num) {
				flag=true; //ON. 배열에 num이 있는 상황을 의미
				index=i;
			}
		}
		
		if(flag) {//만약에 num이 배열에 존재 한다면, true
			System.out.println(num+"은 인덱스 ["+index+"]에 존재합니다!");
		}
		else {// 없다면 false
			System.out.println(num+"은 존재하지않습니다...");
		}
////=====================================flag 알고리즘=====================================
	
	
	
	}
}
