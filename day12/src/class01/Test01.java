package class01; //배열리스트

import java.util.ArrayList;

public class Test01 {
	public static void main(String[] args) {
		
//		int[] data = new int[3];
//		data[0]=10;
//		data[1]=10;
//		data[2]=10;
//		System.out.println(data);
//		
//		data[3] = 40;
//		System.out.println(data[3]);
		
		//향상된 배열 == 배열리스트
		// 특징)
		//  1. 데이터를 마음대로 저장가능
		//  2. toString() 오버라이딩
		//  3. add(),remove(),clear(),size(),get(),... 과 같은 다양한 기능의 메서드를 기본제공
		//  4. 서로 다른 자료형(타입)들도 저장가능
		//		=> 그러나 웹개발 실무에서 반드시 서로 같은 자료형만 취급!
		//		=> 그래서 "강제성"을 부여하여 사용합니다!~~
		// ★★★★제네릭 <> ★★★★ : (일반화) 저장되는 타입을 일반화
//		ArrayList data = new ArrayList();
//		ArrayList<String> data = new ArrayList<>();
		ArrayList<Integer> data = new ArrayList<>(); //add(다른타입) 에러 
		
		Integer i=new Integer(10); //원형
		int ii=10; //원시타입쓰쟝~
		
//		String str = new String("tkrhk");
//		String str1= "tkrhk";
		
		
		data.add(10);
		data.add(0,20); //기존 0인덱스에 있던 10을 뒤로 밀어냄
		data.add(0,30); //10과 20 둘 다 뒤로 밀어냄
//		data.clear(); //싹 지움
//		data.remove(0); //0에 있는거 지워졍 
		data.isEmpty();// 비어있니?? (많이씀) True or False가 나와용
		System.out.println(data.isEmpty());
		System.out.println(data);// .toString 오버라이딩 되어있음
		System.out.println(data.get(0));
		System.out.println(data.size());
	
//		data.add("사과");
		data.add(10);
//		data.add(3.14);
		System.out.println(data);
	}
}
