package class01;

// ★유효성 검사 
public class Test01 {

	public static void main(String[] args) {

		/*
		 * 1. 월이 저장된 데이터(==변수)가 있습니다. 
		 * 3,4,5 -> 봄 6,7,8 -> 여름 9,10,11 -> 가을 12,1,2, -> 겨울
		 * 이라고 console에 출력해주세요
		 */

		int month = 5;//월이 저장된 데이터

		String season; // 결과를 저장할 변수 


		if(1<=month && month <=12) { // 유효한 범위입니까?

			if(3<= month && month <=5) {
				season = "봄";
			}
			else if(month == 6 || month == 7 || month == 8) {
				season = "여름";
			}
			else if(9<= month && month <=11) {
				season = "가을";
			}
			else {
				season = "겨울";
			}

			System.out.println("현재 : " + season);

		}
		else {
			System.out.println("잘못된 값입니다!");
		}
	}
}
