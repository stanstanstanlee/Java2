package class01;

import java.util.Random;
import java.util.Scanner;
/*
+++) 10개의 랜덤 정수가 저장된 배열 (범위:1~100)
 사용자가 정수를 입력 ex) 50
 50은 [2]에 저장되어있습니다. 
 50은 배열에 없습니다!
 */
public class Test02HW02Answer {
	// [1]방식 : 배열에 특정정수가 있는지 없는지- 1
	// 있다면, 몇번인덱스인지 - 2 // 이렇게 두가지 알려줘야함
	// INPUT: int[] 1개, int 1개
	// OUTPUT: (제거: boolean,) int 
	// 		=> 2개이상의 반환은 불가능!
	//		   int의 값에 의미를 부여하는 방식으로 해결! 
	public static int checkNum(int[] data, int num) {
		for(int i=0; i<data.length;i++) {
			if(data[i] == num) { //내가 지금 보고 있는 data[i]가 num이야? 
				return i; //인덱스위치;
			}
		}
		return -1; //인덱스 위치가 될 수 없는 -1음수 값에 의미를 부여 false를 의미함
	}
	public static void main(String[] args) {
		
		Random rand=new Random();
		int[] data=new int[10];
		for(int i=0;i<data.length;i++) {
			data[i]=rand.nextInt(100)+1;
		}
		System.out.print("[ ");
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.println("]");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num=sc.nextInt();
		int index=checkNum(data,num); //함수는 적게 호출 하는것이 좋다. 여러번 호출 되면 느릴수 밖에 없음
		if(index<0){ //배열에 num이 있어?
			System.out.println(num+"은 배열에 없습니다!");
		}else {
			System.out.println(num+"은 ["+index+"]에 저장되어있습니다");
		}
	}
}
