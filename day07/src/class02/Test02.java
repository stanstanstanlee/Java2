package class02;
// 1. 객체끼리 값을 "공유"하는 경우
// static 붙여서 클래스 변수로 선언
// this 안붙임
// 2. 객체들로도 배열을 생성할수있음
// 3. 
class Game {
	String name; //모래성게임을 하는사람이름
	static int res=100; //공유자원. 모래성 : 에다 대입연산자를 붙이는겁니다(공유자원한테만 이렇게 하는겁니다)
	Game(String name) { //<<=생성자
		this.name=name;
		System.out.println(this.name+"님 참가!");
	}
	boolean game(int cnt) { //<<== cnt는 양 : 얼만큼 모래를 긁어갈지; 어디에서? 공유자원에서
		res-=cnt; //공유자원이라 this. 안적음 // this == 자기자신객체; res는 객체에 해당 하는게 아님; 클래스에 해당함
		if(res<=0) {
			System.out.println(this.name+"님 패배...");
			return false; //<<패배
		}
		System.out.println(this.name+"님 성공! 남은모래: "+res);
		return true; //원랜 안졌어
	}
}

public class Test02 {
	public static void main(String[] args) {
		
		Game g1 = new Game("아리");
		Game g2 = new Game("아무무");
		Game g3 = new Game("티모");
		Game g4 = new Game("소나");
		// 객체로 만드는 배열
		// : 객체배열
//		int[] data=new int[4]; //객체배열 생성방법 : 일반배열과 같음
//		data[0]=10;
		Game[] data=new Game[3];
		data[0]=new Game("아리");
		data[1]=new Game("아무무");
		data[2]=new Game("티모");
		int i=0; 
		while(true) { //게임에 지는 사람이 나올때 까지 
//			if(!g1.game(5)) {
//				break;
//			}
//			g2.game(15);
//			if(!g2.game(5)) {
//				break;
//			}
//			g3.game(7); //<<res는 공유자원이였기때문에 7만가져가도 바로 짐
//			if(!g3.game(5)) {
//				break;
//			}
//			for(int i=0; i<data.length;i++) {
//				if(!data[i].game(5)) { //종료조건이 중첩된 반복문안에 들어갈때 다시 한번 확인 : while의 종료조건이 될 수 없음
//					break;			   //for문이 들어갈 타이밍이 아니였던것
//				}
//			}    //함수임 종료조건: 남은모래가 0일때
			if(!data[i++].game(5)) { //중첩 반복문 없이 풀었어야함. if(true)이면 진입함. 객체들이 게임 성공 했을땐 진입하면 안됨 
				break;
			}
//			i++;
			if(i==data.length) {
				i=0;
			}
		}
		//첫번째부터 마지막까지 돌아가면서 
		//순서대로 게임을 할건데, 
		//만약 패배했다면 게임 종료
		
		
		
	}
}
