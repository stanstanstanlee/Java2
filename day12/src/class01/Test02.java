package class01;
//카드류게임에서 집합 많이 사용 : 카드가 중복되면안됨
import java.util.HashSet;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {
		
		// 추상클래스 Set
		// Set류의 부모클래스
//		Set data = new Set(); //Set은 추상클래스이기 때문에 new로 객채화 못함 
//		Set data = new HashSet(); ↓↓↓ 똑같앙
//		HashSet data = new HashSet(); //노란줄 : 제네릭 안걸꺼임???
		HashSet<Integer> data = new HashSet<>();
		
		// 집합(Set)
		// 1. 순서가 없음 (index XXX)
		// 2. 중복 허용 안함
		// 3. 다양한 자료형 저장 가능
		// 	  -> 하지만, 이렇게 사용하지 않음!!!
		//		 => <>제네릭 함께사용
		data.add(10);
		data.add(10);
		data.add(10);
		data.add(1234);
		data.add(1);
		data.add(2);
		data.add(12);
		data.add(13);
		data.add(11);
//		data.add("apple");
		
		System.out.println(data);
		System.out.println(data.size()); //크10개 넣어도 중복빼고 8개라고만 나옴
	}
}
