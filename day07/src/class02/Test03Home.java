package class02;
/*
1. Home의 구성원 객체들을 3명 생성할예정
2. 각 객체들은 고유한 이름(name)을 가짐 
3. Home의 구성원 객체들이 공유하는 계좌가 있음
		      == money
4. money에 10000원있음
5. person.use(5000);
	money를 5000만큼 사용
6. 여러번 사용할 예정
7. money을 0월 이하로 만든사람의 이름을 출력해주세요!~~

※ 인스턴스변수 vs 클래스변수
※ 멤버변수,메서드(+생성자) 고려할것
※ 객체배열
 */
class Home {
	//인스턴스변수
	String name;
	static int money = 10000; //공유자원, 클래스변수
	//생성자
	Home (String name){
		this.name=name;
		System.out.println(this.name+"님 머니게임 참가.");
	}
	//메서드(기능)
	boolean use(int m) {//use(5000) : m으로 받아올것
		money-=m; //use(5000) 하면 공유자원 1만원 짜리 money에서 그만큼 빠져나감==>m으로 받아올것
		if(money<=0) {
			System.out.println(this.name+"님이 돈을 다썼습니다. 파산");
			return false; //패배
		}
		System.out.println(this.name+"님은 돈을 남겼습니다. 남은 돈: "+money);
		return true; //원랜 안졌어
	}
}

public class Test03Home {
	public static void main(String[] args) {
//		Home p1 = new Home("존윅");
//		Home p2 = new Home("타잔");
//		Home p3 = new Home("티모");
		//객체배열
		Home data[] = new Home[3];
		data[0]=new Home("존윅");
		data[1]=new Home("타잔");
		data[2]=new Home("티모");
		//person.use(5000);
		//money를 5000만큼 사용
		System.out.println(data.length);
		int i = 0;
		while(true) { //게임 끝날때까지 진행
			
			if(!data[i++].use(3000)) { // 종료조건 : 돈 바닥낸 사람 나올때 까지 
				break;
			}
			if(i==data.length) {
				i=0;
			}
		}
		
		
	}
}
