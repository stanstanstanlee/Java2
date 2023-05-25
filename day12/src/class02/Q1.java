package class02;

import java.util.HashSet;
import java.util.Random;

/*
1. 10개의 랜덤수를 생성해주세요.
(범위는 1~15까지입니당)
중복을 제외하고 생성된 랜덤수의 개수와 
	랜덤수를 출력해주세요!~~
랜덤수는 3개 생성되었고,
	[ 1, 2, 3 ] 입니다. 
 */
//-----------------
/*
	중복을 제외하고 -->> Set? import
	
	HashSet<Integer> data = new HashSet<>();
	
	랜덤수 Random 클래스 import 하기 
	
	data.add();로 넣기?
	
	10개의 랜덤수 for?
	
	1~15는 nextInt(15)+1;
	
	생성된 랜덤수의 개수 .size 
	랜덤수를 출력	syso("랜덤수는 " + data.size +"개 생성되었고,\n"
					+ data +"입니다.")
 */
public class Q1 {
	public static void main(String[] args) {
		Random rand = new Random();
		HashSet<Integer> data = new HashSet<>();
		
		for(int i=0;i<10;i++) {
			data.add( rand.nextInt(15)+1 );
		}
		
		System.out.println("랜덤수는 " + data.size() +"개 생성되었고,\n"
				+ data +" 입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
