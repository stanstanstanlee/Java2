package class01;
// import java.util.Random;
// class Pokemon
//  - String name
//  - int win 이긴횟수
//  - void hello() : 각각의 포켓몬마다 고유한 소리를 출력
//	  메서드 시그니처 만들때는 고려해야 하는게 기능
//  - boolean game(Pokemon pokemon) - 게임은 어떤 애들이든 동일하게 진행 할 예정==추상메서드가 아님)
//		-> pokemonA.game(pokemonB); //<<==주어가 되는 내가 이기면 true // 메서드는 주어를 기준으로
//		   홀홀 작은값이 이김
// 		   짝짝 큰값이 이김 
// 		   홀짝 홀수가 이김
// class 생성시
// 1. abstract일까?
//    1) 이 클래스의 객체가 필요한가?
// 	  2) 추상메서드가 있나? == 오버라이딩을 강제해야하는 메서드가 있나?
//					    		== 재정의해야하는 메서드가 있나?
// 2. 멤버변수생성
//		1) private
//		2) getter, setter 일단 만들어
// 3. 생성자
// 4. 메서드
// 		1) 이거 오버라이딩(재정의)을 강제해야되나? => 추상메서드로 만들어야하나?
//		2) '기능'을 보고, "INPUT, OUTPUT"을 생각하여 '메서드 시그니처' 작성
abstract class Pokemon {
	private String name;
	private int win;
	Pokemon(String name) { // 추상클래스 생성자 소유 가능; new를 못스는것 뿐이지 생성자는 가질 수 있음
		this.name=name;
		this.win=0;
	}
	abstract void hello();
	boolean game(Pokemon pokemon) { //-> pokemonA.game(pokemonB); //<<==주어가 되는 내가 이기면 true // 메서드는 주어를 기준으로
// 		- 홀홀 작은값이 이김; 
		  	//if(주어도 홀이고 상대도 홀이면 누구 값이 더 작은지 비교) { 값을 어디서 가져옴? 객체화 부분에서 인수로 전달?
			//		이기면 win++
			//		작은값이 이김; 
			//		return true; 
			//}
// 		- 짝짝 큰값이 이김; 
			//if(주어도 짝이고 상대도 짝이면 누구 값이 더 큰지 비교) {
			//		이기면 win++
			//		큰값이 이김;
			//		return true;
			//}
// 		- 홀짝 홀수가 이김;  
			//if() { //주어가 홀이고 상대가 짝이거나 주어가 짝이고 상대가 홀이면 : 둘의 값이 홀짝이면 
			// 		이기면 win++
			//		홀수가 이김;
			//		return true;
			//}
		return false;//지면; true를 반환 받으면 주어가 win++;어디서 증감???
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
}
class Pika extends Pokemon {
	//1번 이슈: 메서드 안만든거 있어~~ => 오버라이딩 강제되고있는 메서드(추상메서드)
	//		   => 1. 나도 추상클래스 하던지
	// 			  2. 추상메서드 오버라이딩 하던지 ◀
	//2번 이슈: 생성자; 부모의 super()를 호출하는 중이야~~~ => 부모클래스에게는 기본생성자가 현재 없음
	//		   => 1. 부모클래스에 기본생성자 만들던지
	// 		      2. 부모클래스의 다른생성자를 사용하던지 ◀ 자식클래스만들다가 부모클래스 수정하는 일은 없어야 함
	Pika() {
		super("피카츄"); //모든 피카츄 객체는 이름이 피카츄 
	}
	@Override
	void hello() { //피카츄 고유 울음소리 재정의
		System.out.println("피카피카~");
	}
}
//게임 대상이 있으려면 자식 클래스 하나 더 만들어야함
class Charm extends Pokemon{
	Charm() {
		super("파이리"); //모든 파이리 객체는 이름이 파이리
	}
	@Override
	void hello() { //파이리 고유 울음소리 재정의
		System.out.println("파아파아~");
	}
}
public class Test03 {
	public static void main(String[] args) {
//		pokemonA.game(pokemonB); //반환값이 true혹은 false
//
//			pokemonA.setWin() 

		
		
	}
}
