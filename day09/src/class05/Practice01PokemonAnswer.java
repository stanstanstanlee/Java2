package class05;

import java.util.Random;

class Pokemon {
	String name;
	int exp;
	int lv;
	String sound;
	static Random rand=new Random();
	//생성자 오버로딩
	Pokemon() { // 지정하지않는 경우에는 디폴트로 "포켓몬"이 설정됨 
		this("포켓몬");
	}
	Pokemon(String name) { //이름을 사용자가 지정할수도있고
		this.name=name;
		this.exp=0;
		this.lv=5;
		this.sound="";
	}
	//메서드
	void game() { //확률을 사용자가 정한다면 인자를 받아야함 //인자가 있으면 사용자가 입력한다라고 보임 
		int action=rand.nextInt(2);
		if(action==0) {
			gameT();//System.out.println("성공");
		}
		else {
			gameF();//System.out.println("실패");
		}
	}
	void gameT() {
		this.exp += ( rand.nextInt(41)+10 );
		System.out.println(this.name+", 성공!");
	}
	
	void gameF() {
		this.exp+=10;
		System.out.println(this.name+", 실패...");
	}
	
	void hello() {
		System.out.println(this.name+"(이)가 쳐웁니다 : "+this.sound);
	}
	void printInfo() {
		System.out.println(this.name+"(은)는 Lv. "+this.lv+" ["+this.exp+"/100]" );
	}
	void lvUp() {
		while(this.exp>=100) {
			this.exp-=100;
			this.lv++;
			System.out.println(this.name+", 레벨업!");
		}
	}
} 

class Pika extends Pokemon {
	//생성자
	Pika () {
		this(5);
	}
	Pika(int lv) { //무조건 인자가 더 많은 것 부터 만듭니당
		super("피카츄");
		this.lv=lv; // 내 레벨을 바꿔줘야함
		this.sound="피카~~";
	}
	//메서드 오버라이딩
	void game() { //레벨업 해야됨
		int action=rand.nextInt(1);
		if(action==0) {
			gameT();//System.out.println("성공");
		}
		else {
			gameF();//System.out.println("실패");
		}
		lvUp();
	}
//	void hello() { //오버라이딩
//		System.out.println("피카피카");
//	}

}
class Charm extends Pokemon {
	//생성자
	Charm () {
		this(5);
	}
	Charm(int lv) { //무조건 인자가 더 많은 것 부터 만듭니당
		super("파이리");
		this.lv=lv; // 내 레벨을 바꿔줘야함
		this.sound="파아~~";
	}
	void game() { //레벨업 해야됨
		int action=rand.nextInt(5);
		if(action==0) {
			gameT();//System.out.println("성공");
		}
		else {
			gameF();//System.out.println("실패");
		}
		lvUp();
	}
//	void hello() { //오버라이딩 : 상속관계에서 일어나며 메서드 시그니처가 동일 해야 한다
//		System.out.println("파아~~");
//	}
}

public class Practice01PokemonAnswer{
	public static void main(String[] args) {
		Pika p1=new Pika(); // 피카츄,5,0
		Pika p2=new Pika(10); // 피카츄,10,0
		
		Charm c1=new Charm();
		Charm c2=new Charm(11);
		
		for(int i=0; i<10;i++) {
			p1.game();
			p2.game();
			c1.game();
		}
		p1.printInfo();
		p2.printInfo();
		p1.hello();
		c2.hello();
		
	}
}
