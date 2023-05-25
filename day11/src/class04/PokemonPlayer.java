package class04;
class Player { //Player클래스는 포켓몬클래스랑 상속관계가 아님 그냥 상호작용
				// 
						
	/*// 2. 멤버변수 생성
//    1) private
//    2) getter,setter
[멤버변수]
 -인스턴스 변수:
 	private int preIndex; // 
 -클래스 변수:
 	final static int maxIndex=3; // 변하면 안됨; 객체와 무관하게 길이는 3으로;
 	private Pokemon[] data = new Pokemon[maxIndex]; new = 연산자 쓸수 있음 //static일수가 없음 객체와 연관 많음
 							
 -getter,setter:

[생성자] 멤버변수 초기화
	class Player(int preIndex) { 
		this.preIndex=1; // 선택 1에서 시작(배열인덱스 0에서 시작)
		메인에서????data[0]=new Pikachu(); <<== 무조건 첫 포켓몬은 Pikachu가 되게/Player 생성시 최초 소지 포켓몬은 무조건 피카츄이다
		this.data[this.preIndex++]=new Pika();
	}

[메서드]

1) 플레이메서드
	
	Player가 포켓몬 어떻게 대결시킴??
	pika.game(m1);
	pika주체객체랑 m1상대객체를 Pokemon[] data에서 랜덤으로 뽑아와야함 ==>>  
	그리고 그걸 pika.game(m1);이런 형식으로 만들어줘야 함?
	그러면 주체 객체 포켓몬 1마리랑 인수에들어갈 상대객체 포켓몬 1마리 필요. 
	
   기능 : - data에 저장된 포켓몬을 '랜덤으로' 2마리 선택하여 게임을 진행; 
   			단, 2마리의 포켓몬이 서로 같은 포켓몬이면 더이상 진행하지않음
   		  	[Object최상위클래스->equals() 오버라이딩]
   		 
   		 - 클래스 타입이 같으면 같은 포켓몬
   		 
   		 - 서로 다른 포켓몬이면 포켓몬.game()을 진행함; 
   		 		pika.game(m1); ==>> boolean T or F 반환 받음 
   		 
   		 - 이긴 포켓몬의 울음소리가 console에 출력됨
   		 			이긴 포켓몬의 void hello()메서드를 호출 해야함?? ==.hello(); 로 할 수 있음
 			
   INPUT : 필요없음   ==>> nono XXXX ??????Pokemon[] data를 인자로 받는거???
   OUTPUT : 없음
   void play() {
   		data에 저장된 포켓몬을 랜덤으로 2마리
   		Random rand=newRandom();
   		int num1=rand.nextInt()0~현재 존재하는 마리수까지;
   		int num2=rand,nextInt();
 
 
2) 	Pokemon[] data 배열에다 저장 메서드
			data[0]에는 이미 피카츄객체가 저장 되어 있음 data[0]=new 피카츄(); 
	기능: data[1]과 data[2]에 두마리 다른 포켓몬 객체를 저장 해야함. 하드코딩?
		 data[1] = new 인풋으로 들어온 클래스값();
		 data[2] = 인자로 받은객체;
		 ??이렇게???
	
	INPUT : 인자로 클래스 못받음. 인자로 객체 받고 받은 객체를 new까지 (객체를 메인에서 생성을 해 놓아야함)
			인자로 객체를 받으려면 (Pokemon pokemon)
	OUTPOUT : 없음?
   아웃풋 저장(인자) {
   			
   }
	 */
	
	private int preIndex;
	final static int maxIndex=3;
	private Pokemon[] data = new Pokemon[maxIndex];
	
}
abstract class Pokemon {
/* 
//멤버변수
	String 이름
	int 이긴수
//생성자

//메서드
     기능 : 이긴 포켓몬의 울음소리가 console에 출력됨; 포켓몬.hello()
     INPUT : 없음
     OUTPUT : 없엉
 	 void hello() { 
 	 	syso(˚▽˚); //울음소리 ===>> 자식 포켓몬 클래스들에서 오버라이딩 해야함
 	 }
 */
}

class Pikachu extends Pokemon{
	
}


public class PokemonPlayer {
	public static void main(String[] args) {
		
	}
}
