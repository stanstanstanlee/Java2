package class01;

import java.util.Random;
import java.util.Scanner;

public class Test06Q1Function {
	
	public static String getAns(String numStr) {
		String coAns="";
		
		return coAns;
	}
	
	
	public static void main(String[] args) {
		// 1~1000중의 랜덤 정수 1개 생성
		// 랜덤 정수 1개 저장 (변수)
		// 랜덤 정수 출력 하고 [num]
		// 정답인 경우 :
		//		3,6,9,중 하나도 없으면 랜덤값과 같은 정수를 입력 해야 함
		// 		3,6,9 중 아무거나 하나당 짝 한번
		// 		'짝' '짝짝' '짝짝짝' 입력 받아야함
		// 사용자가 답 입력 : 
		//	뭘 입력 받아야하지? 한글 문자열? int 입력 받아야하나?
		//--------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int num = rand.nextInt(1000)+1; //랜덤정수 저장 1~1000
		System.out.print("[");
		System.out.print(num);
		System.out.print("] : ");
		// num가 3,6,9중 하나라도 포함 하고 있는지 어느숫자 어디에 포함 하고 있는지 확인
		// num을 스트링으로 바꿈?
		String numStr = Integer.toString(num); // 랜덤값을 문자열로 바꾸고 담을 변수??
		//----함수1개?
		String coAns = ""; //정답 담아둘 변수 coAns == 정답지;
		
		//  - 정수가 3,6,9,중 하나 포함
		// 	charAt()
		//						3,6,9중 하나라도 있을때 마다 짝++
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                coAns += "짝";
            }
        }
       System.out.println("정답지 :" + coAns); // 출력으로 정답지확인
        System.out.println("답 입력 : ");
		//3,6,9 중 하나도 포함 안된 정수가 나오면 해당 정수를 그대로 입력 해야함
		String userAns = sc.next(); //사용자의 정답 받을 변수
		
//-------------------------------------------------------------------------------
		if(coAns.equals(userAns)) {// '짝', '짝짝', '짝짝짝'이 정답일 경우
			System.out.println("정답입니다!");
		}else if(coAns.equals("")) {
			if(userAns.equals(numStr)) {
				System.out.println("정답입니다!");
			}else System.out.println("오답입니다!");
		}else System.out.println("오답입니다!");
	}
}
