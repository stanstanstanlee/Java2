package class04;

import java.util.Random;

/*
포켓몬 클래스
	이름
	경험치	: 0
	레벨		: 5
	게임()
		50% 게임성공
		성공 : 경험치+10~50 랜덤상승
		실패 : 경험치+10 상승
	대화()
	상태출력()
	  ㅁㅁㅁ는 Lv.ㅁ [__/100]
피카츄 클래스
	게임()
		100% 게임성공
	대화()
		피카피카
파이리 클래스 
	게임()
		20% 게임성공
		 -> 1~5 : 1 나오면 성공
	대화()
		파이파이
main()에서 
	피카츄 2마리
	파이리 1마리 생성
	게임을 각각 10번씩 시켜서 결과 출력 

 */
/*-----------------------------------------------------------------------------------------------
포켓몬 부모 클래스 생성 
	매게변수 (공유자원??없는것 같은디??)
		String name;
		String chat;
		int exp;
		int lv;
		
	생성자 
		Pokemon(String name, int exp, int lv, String chat) { 모든 매게변수를 초기화 할 수 있는거 먼저 
			this.name=name;
			this.chat=chat;
			this.exp=exp;
			this.lv=lv;
		}
	메서드
		게임() { //디폴트
			Random r = new Random();
			int c = 0; // 50% 랜덤이니까 랜덤클라스 필요
			c = r.nextInt(2);
				if(만약 0이라면 실패) {
					this.exp+=10; //실패면 겸치 10 상승
				}
				else (만약 1이라면 성공) {
					this.exp=r.nextInt(41)+10; //성공하면 겸치 10~50 랜덤상승
				}
		}
		대화() {//디폴트
			syso(this.name+"이 말합니다, " + this.chat);
		
		}
		상태출력() {
			syso(ㅁㅁㅁ(은)는 Lv. ㅁ [__ / 100]);
		}

피카츄 자식 클래스 생성
	매게변수
	생성자
	메서드
		게임() 오버라이딩
		대화() 오버라이딩
		상태출력() 오버라이딩
		
파이리 자식 클래스 생성
	매게변수
	생성자
	메서드
		게임() 오버라이딩
		대화() 오버라이딩
		상태출력() 오버라이딩
 */
//===============================================================================================
class Pokemon {
	String name;
	String chat;
	int exp;
	int lv;
	//생성자
	Pokemon(String name, String chat) {
		this(name,0,0,"");
	}
	Pokemon(String name, int exp, int lv,String chat) {
		this.name=name;
		this.chat=chat;
		this.exp=exp;
		this.lv=lv;
	}
	//메서드
	//기능 : 
	//INPUT : 
	//OUTPUT :
	void playGame() { //레벨업 해야됨
		Random r = new Random();
		// 50% 랜덤이니까 랜덤클라스 필요
		int c = r.nextInt(2);
			//level up
			if(this.exp>=100) {
				this.lv+=lv;
				this.lv++;
				this.exp=0;
			}
			if(c==0) {//만약 0이라면 실패
				this.exp+=10; //실패면 겸치 10 상승
			}
			else {//만약 1이라면 성공
				this.exp=r.nextInt(41)+10; //성공하면 겸치 10~50 랜덤상승
				this.exp+=exp;
			}
			
	}
	//기능 : 
	//INPUT : 
	//OUTPUT :
	void say() {
		System.out.println(this.name+"(이)가 웁니다~"+this.chat);
	}
	//기능 : 
	//INPUT : 
	//OUTPUT :
	void printInfo() {
		System.out.println(this.name+"(은)는 Lv. "+this.lv+" ["+this.exp+"/100]" );//ㅁㅁㅁ(은)는 Lv. ㅁ [__ / 100]
	}
}

class Pikachu extends Pokemon {
	//생성자
	Pikachu () {
		super("피카츄","pika pika");
	}
	//메서드 오버라이딩
	void playGame() {
		// 100% 
		Random r = new Random();
		this.exp=r.nextInt(41)+10; //100프로의 확률로 겸치 10~50 랜덤상승
	}
}

public class Practice01Pokemon {
	public static void main(String[] args) {
		Pikachu p1 = new Pikachu();
		
		p1.playGame();
		p1.say();
		
		for(int i=0; i<11;i++) {
			p1.playGame();
			p1.printInfo();
		}
		
	}
}
