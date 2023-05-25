package class03;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2Answer {
   public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);
      ArrayList<Integer> data=new ArrayList<Integer>();
      
      while(true) { //저장기능
         System.out.print("입력) ");
         int num=sc.nextInt();
         if(num==0) {
            break;
         }
         data.add(num);
      }
      
      int sum=0;
      /*
      for(int i=0;i<data.size();i++) {
         sum+=data.get(i);
      }
      */
      for(int v:data) {
         sum+=v;
      }
      double avg=sum*1.0/data.size();
      System.out.println("평균: "+avg);
      
      // 처음부터 끝까지 돌면서
      // data의 모든 요소를 확인할거야~
      // [ a b c ] 요소 b를 삭제
      // [ a c ] 삭제한 인덱스부터 재확인!
      System.out.println(data);
      int cnt = 0;
//      for(int i=0;i<data.size();i++) {
//         if(data.get(i)%2==0) {
//        	 cnt++;
//         }
//         else { 
//        	data.remove(i);
//         	i--;
//         }
//      }
      //삭제한 인덱스부터 재확인!==>> 언제 검사가 완료 될지 모른다 ==>> while() 
      int index=0;
      while(index<data.size()) {
    	  if(data.get(index)%2==1) {//만약에 삭제해야 하는일이 발생했다면 증감 하면 안된다
    		  data.remove(index);
    		  continue;
    	  }
    	  cnt++;
    	  index++;
      }
      System.out.println("짝수 몇개? "+cnt+"개\n짝수만 남은 배열: "+data);

            
            
   }
}