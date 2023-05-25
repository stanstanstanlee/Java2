package class02;

import java.util.Random;

/*
1. Home의 구성원 객체들을 3명 생성할예정
2. 각 객체들은 고유한 이름(name)을 가짐 
3. Home의 구성원 객체들이 공유하는 계좌가 있음
		      == money
4. money에 10000원있음
   ※↓객체임 : 소문자로 시작; .(점) 앞에 있음 ==>> 어 person은 객체구나
5. person.use(5000);  ===>>> .use 는 메서드구나
	money를 5000만큼 사용
6. 여러번 사용할 예정
7. money을 0월 이하로 만든사람의 이름을 출력해주세요!~~

※ 인스턴스변수 vs 클래스변수
※ 멤버변수,메서드(+생성자) 고려할것
※ 객체배열
 */
class Home2{
	String name;
	static int money=10000;
	Home2(String name){
		this.name=name;
	}
	
	boolean use(int money) {
		System.out.println(this.name+"님이 "+money+"원 결제중입니다!");
		if(Home.money<=money) { //돈을 긁기전에 확인부터 해야함 
			System.out.println(this.name+"님이 과소비중입니다...");
			return false;
		}
		Home.money-=money; //돈을 무한정 쓸 수 없음// 로직:(실제에 가깞게) 돈을 긁기전에 확인부터 해야함 
		return true;
	}
}


public class Test03HomeAnswer {
	public static void main(String[] args) {
		Home2[] data=new Home2[3];
		data[0]=new Home2("홍길동");
		data[1]=new Home2("애쉬");
		data[2]=new Home2("애니");
		
		Random rand = new Random();
		int i = 0;
		while(true) {    //while과 종료조건은 붙어다녀야 함
			int randMoney=(rand.nextInt(50)+1)*100;
			if(!data[i++].use(randMoney)) { //종료조건 : 공유자원이 0이하면 이름출력하고 종료)
				break;
			}
			if(i==data.length) {
				i=0;
			}
		}
		
		
	}
}
