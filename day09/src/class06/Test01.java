package class06;

import java.util.Random;

/*
클래스 구현하기
 1) 멤버변수 3개이상
   클래스변수는 포함시켜도되고,안해도되고
 2) 메서드 2개이상
   오버라이딩 1개포함해서 메서드 2개이상
 3) 생성자 오버로딩 사용
   this 활용
   super 활용

main()에서 부모클래스 객체 1개,
   자식클래스 객체 2개 생성하여 사용하고
   console 화면 보여주세요!~~

+++) 객체배열 활용해보기

ex) 사람-학생, 캐릭터-딜러-겐지, 과일-사과, 동물-강아지·고양이, 책-소설, ...
 */
//===============================================================
/* 										(부모) Character - (자식) Warrior , Rogue

Character 클래스 생성

멤버변수 
	String name; //캐릭터이름 설정

	int dmg; //공격했을때 데미지 	//직업들마다 다르게 가짐

클래스변수
	없음????
	
생성자 //(this, super 활용) 생성자 오버로딩 해야함 
	
	Character () {
		this("캐릭터");
	}
	
	Character (String name) { //인자가 가장 많은 것 부터 //멤버변수 초기화 해야함
		this.name = name; //이름 사용자한테서 받아올 것임

		this.dmg = 1; 
	}

메서드
	기본공격() {}
		기능: 기본 공격 해야함. 오버라이딩) 다른 직업들은 그냥 기본 데미지만 다름
		INPUT: int dmg
		OUTPUT: 없음??
		디폴트 : 0~1;
		전사는 기본 데미지 10~20
		로그는 기본 데미지 5~10
		syso(this.name+"님이 공격 합니다" + dmg +"만큼의 피해를 입혔습니다" ); 
		
	스킬공격() {}
		기능: 스킬 공격 해야함. 오버라이딩) 
		INPUT: int dmg
		OUTPUT: 없음???
		Random
		디폴트 3;
		전사는 스킬 데미지 20~30
		로그는 스킬 데미지 10~20 
		

		syso(this.name님이 스킬 공격으로 + dmg 만큼의 피해를 입혔습니다. this.hp);
		

Warrior 클래스 생성
	//멤버변수
	//생성자
	//메서드

 */
class Character {
	//멤버변수
	String name; //캐릭터이름 사용자가 설정
	int dmg; //공격했을때 데미지 	//직업들마다 다르게 가짐
	static Random rand=new Random();
	
	//생성자 오버로딩
	Character () {
		this("캐릭터"); //이름 없으면 걍 캐릭터??
	}
	
	Character (String name) { //인자가 가장 많은 것 부터 //멤버변수 초기화 해야함
		this.name = name; //이름 사용자한테서 받아올 것임
		this.dmg = 0; 
	}
	
	//메서드
	void attack() { //기본공격
		this.dmg=rand.nextInt(2)+1; //디폴트 1~2
		printAttack(); //ㅁㅁㅁ이(가) 기본공격
		printDmg();////데미지 몇나오는지 보여줌
	}
	
	void useSkill() { //기능: 스킬 공격 해야함. 오버라이딩) 
		this.dmg=rand.nextInt(2)+2; //디폴트 2~3
		printSkill();//ㅁㅁㅁ이(가) 스킬공격
		printDmg();
	}
	
	void printDmg() {////데미지 몇나오는지 보여줌
		System.out.println(this.dmg +"만큼의 피해를 입혔습니다");
	}
	void printAttack() {//ㅁㅁㅁ이(가) 기본공격
		System.out.print(this.name+"님이 기본공격 : ");
	}
	void printSkill() {//ㅁㅁㅁ이(가) 스킬공격
		System.out.print(this.name+"님이 스킬공격 : ");
	}
}
class Warrior extends Character {
	//멤버변수
	int mp; //마나
	int mpMinus; //줄어들 마나양???
	int mpMax; //최대 마나 0보다 작을순 없는디??
	//생성자 오버로딩
	Warrior() {
		super("전사"); //이름 안지어주면 걍 전사임
	}
	Warrior(String name) { //이름 지어주면 그거 가져옴 
		super(name);
		this.mpMax=100;
		this.mpMinus=15;
		this.mp=mpMax;
	}
	
	//메서드 오버라이딩
	void attack() {//전사는 기본 데미지 5~10
		this.dmg=rand.nextInt(11)+10;
		printAttack();//ㅁㅁㅁ이(가) 기본공격
		printDmg();//데미지 보여줌
	}
	void useSkill() {
		this.dmg=rand.nextInt(11)+20; //전사는 스킬 데미지 20~30
		printSkill();//ㅁㅁㅁ이(가) 스킬공격
		printDmg();//데미지 보여줌
		
		// 마나 줄어들게 해야 함
		this.mp-=this.mpMinus;
		
	}
	
}
class Rogue extends Character {
	//멤버변수
	
	//생성자 오버로딩
	Rogue() {
		super("도적"); //이름 안지어주면 걍 도적임
	}
	Rogue(String name) { //이름 지어주면 그거 가져옴 
		super(name);
	}
	//메서드
	void attack() {//도적은 기본 데미지 5~10
		this.dmg=rand.nextInt(6)+5;
		printAttack(); //ㅁㅁㅁ이(가) 기본공격
		printDmg(); //데미지 보여줌
	}
	void useSkill() {
		this.dmg=rand.nextInt(26)+10; //도적은 스킬 데미지 10~35
		printSkill(); //ㅁㅁㅁ이(가) 스킬공격
		printDmg();//데미지 보여줌
	}
}


public class Test01 {
	public static void main(String[] args) {
		Character c1 = new Character();
		Character c2 = new Character("이용자");
		Warrior w1 = new Warrior();
		Warrior w2 = new Warrior("킹왕짱용사");
		Rogue r1 = new Rogue();
		Rogue r2 = new Rogue("루피");
		
		c1.attack();
		c1.useSkill();
		System.out.println();
		c2.attack();
		c2.useSkill();
		System.out.println();
		w1.attack();
		w1.useSkill();
		System.out.println();
		w2.attack();
		w2.useSkill();
		System.out.println();
		r1.attack();
		r1.useSkill();
		System.out.println();
		r2.attack();
		r2.useSkill();
	}
}
