package class01;
import java.util.Scanner;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Random random = new Random();           // 랜덤함수를 사용하기위한 선언
        int number = random.nextInt(1000) + 1;  // int 정수자료형 number 초기화 
          // random.nextInt(1000) + 1 이것의 의미는 random 내장함수를 사용하는대 
          // 정수 1~1000까지 숫자중을 지정함 , +1의 이유는  프로그래밍은 0부터 시작하기떄문에 +1을 해줌 
                                               
        String result = "";
        // String 문자열자료형 에 1~1000까지의 랜덤된 정수 넣어줌 
       /*Integer.toString() 해당 함수를 사용하는 이유는  string 과 int 자료형이 다르기때문에  
         int형인(정수)  number 의 변수를 string 으로 변환해주는것임 
        */

        String str = Integer.toString(number);
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                result += "짝";
            }
        }
        /* for (){} 문은 반복문
           i=0 으로 시작되는 반복문인대 플러스1씩 증가하지만 str.length() 배열의 크기만큼 반복됨 
           ex)   number =345 라면  3번 반복되는 것임 
           
            char c = str.charAt(i); 이것은  char 이라는 자료형을 이용하는 것인대 
            문자열이 아닌 한단어를 뜻함... (이건좀 어려울듯)
            아무튼  char c = str.charAt(i); 를 예를 들어 말해주면 
            number 가 345의 경우  str.charAt(0)  == 3 
                                 str.charAt(1)  == 4 
                                 str.charAt(2)  == 5
                                 로 볼수있음 
                                 
           if문  
            if (c == '3' || c == '6' || c == '9') {  은  위에 나온
            str.charAt(0)  == 3 이  3 또는 6 또는 9에 포함되는 단어이기 때문에 true 로 반환 
            따라서  result = "짝"; 의 조건문 안으로 들어오는 것임 
            
            
        */

        
        System.out.println("["+str + "]"+"  " + result);
        
    }
}