package class03;

import java.util.HashSet;
import java.util.Random;

public class Q1Answer {
   public static void main(String[] args) {
      
      // 1개씩 10번 VS 10개를 1번
      // -> 어떤 자료형을 선택하는지?
      // 배열 < 컬렉션(배열리스트,집합)
      // 배열리스트 < 집합
      // Set은 인덱스가 없음 : 정렬이라는 개념이 성립이 안됨 
      HashSet<Integer> data=new HashSet<Integer>();
      Random rand=new Random();
      
      for(int i=0;i<10;i++) {
         int num=rand.nextInt(15)+1;
         System.out.println("랜덤수: "+num);
         data.add(num);
      }
      
      System.out.println(data.size());
      System.out.println(data);
      
      // +) 만약, 정렬이 하고싶다면?
      // 집합 xxx -> 배열리스트로 이동해서 정렬
      
      
      
      
      
   }
}