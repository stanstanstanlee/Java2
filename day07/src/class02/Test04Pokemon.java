package class02;

import java.util.Random;
import java.util.Scanner;

/*
포켓몬 클래스가 있습니다.
이 클래스로 포켓몬 객체들을 생성할겁니다.

포켓몬 객체들을 3마리 저장할예정입니다. >> "이름과 레벨은 사용자로부터 입력받고, 경험치는 0~10중에서 랜덤생성"
포켓몬은 이름,레벨,경험치가 있습니다.
po.printInfo();
   -> 피카츄 Lv5. [5/100]
프로그램을 무한하게 동작시킬예정입니다. while
각각의 포켓몬 객체들은 game()을 진행합니다.
경험치가 100이될때마다 레벨은 1씩 증가합니다.
   레벨 1 증가시, "피카츄, 레벨업!" 문장을 출력해주세요.
po.game();
   -> 성공시 경험치가 50~150중에서 랜덤만큼 증가
   -> 실패시 경험치가 10증가 => 50:50확률로 성공 or 실패(HINT. 0이면 실패 1이면 성공)
   
+) po.game()을 순서대로 동작시키는 방법
+++) po.game()을 입력받아서 동작시키는 방법
 */
//=========================================================================================================
/*
1. 포켓몬클래스 생성
2. 멤버변수 이름, 레벨, 경험치 만들기. 
3. 클래스변수는 없는 것 같다... 잘모르겠다...
4. 생성자에서 객체의 이름과 레벨을 "입력" 받음(Scanner) 
			Scanner를 main에서 만들고 입력받고 객체로 전달 한 다음 생성자로 받음?
			경험치 랜덤생성 (배열 아닌것 같은데?) 
			int = 0으로 초기화하고 함수game()에서 .nextInt()로 받음?
			객체가 3개면 

6. printInfo() 함수를 쓰면 "이름 Lv.# [#/100]" 이 나오게 해야함

7. game()이라는 함수 생성; 프로그램을 무한하게 동작시킬예정입니다. while
						?????????? 그럼 main에서 while?
						game(); 함수 안에서 while
	
8. po.game() 성공 or 실패 (HINT: 0이면 실패 1이면 성공)
	 1) 생성자에서 만든 경험치 Random으로??
	 2) 성공시 => 경험치 50~150중에 랜덤으로 증가
 	      실패하면 경험치가 10증가 
 	while(true){    
 	    random?? 0 or 1 
 	    int a = r.nextInt(2) // 0~1 <<== 함수 실행 될 때 마다?
 	    먼저 한 후
 	    if(a==1) {
 	    	exp = r.nextInt(101)+50// 0~100 =>> 50~150
 	    }else {
 	    	exp+=10;
 	    }
 	    성공 or 실패후 // 100을 넘기면 레벨이 자동으로 1올라가야함   
						==>> 이때 다시 출력해야함 "ㅁㅁㅁ, 레벨업!"
 	    if(exp>=100) {
 	    	lv++;
 	    	syso(name+", 레벨업! " + lv);
 	    	exp = 0;
 	    }
 	    if(종료조건) {
 	    
 	    }
 	} 
9. printInfo() 하면 일자로 같이 나와야함
	이름 : 입력받은거 Scanner로 main 에서 입력받고 객체로 전달 한 다음 생성자로 받음?
	Lv :    ↑ 같음?
	경험치 : [exp / 100]
	경험치는 0으로 초기화? 100을 넘기 못하도록? 0이하가 안되도록
		syso(name+" Lv"+ lv +". ["+exp+"]" );
		
10.		
 
 */
class Pokemon {//포켓몬 클래스생성
	//멤버변수 : 이름, 레벨, 경험치(랜덤생성)
	String name;
	int lv;
	int exp; //경험치 랜덤생성 받을 거임

	//생성자 //이름과 레벨은 사용자로부터 입력받고
	Pokemon (String name, int lv) {
		this.name=name;
		this.lv=lv;
		this.exp = 0;
	}
	//메서드 : po.printInfo(); 객체.메서드(); 
	//-> 피카츄 Lv5. [5/100]
	void printInfo() {
		System.out.println(name+" Lv"+ lv +". ["+exp+"/100]" );
	}
	/*
	po.game(); 50:50확률로 성공 or 실패(HINT. 0이면 실패 1이면 성공)
   -> 성공시 경험치가 50~150중에서 랜덤만큼 증가
   -> 실패시 경험치가 10증가 => 
	 INPUT : po.game(); 인자 없음
	 OUTPUT : 없음???
	 */
	void game(){ //po.game();
		Random r = new Random();
		int a = r.nextInt(2); // 0~1 <<== 함수 실행 될 때 마다?
		if(a==1) {
			exp += r.nextInt(101)+50;// 0~100 =>> 50~150
			
			if(exp>=100) {
				System.out.println("성공! "+name+"님이 "+exp+"만큼의 경험치를 얻었습니다.");
				lv++;
				exp = exp-100;
				System.out.println(name+", 레벨업! ["+exp+"/100]");
			}else System.out.println("성공! "+name+"님이 ["+exp+"]만큼의 경험치를 얻었습니다 ["+exp+"/100]");
			
		}
		
		if(a==0) {
			exp+=10;
			System.out.println("실패. "+name+"님이 10의 경험치를 얻었습니다 [" +exp+"/100]");
		}
	}
}

public class Test04Pokemon {
	public static void main(String[] args) {
		//Scanner로 포켓몬 이름, 레벨 입력 받아야함
		Scanner sc = new Scanner(System.in);
		
		//객체를 3개를 생성후 각 이름과 레벨을 모두 입력 받아야 하기 때문에 객체배열로 생성하는게 나을듯
		Pokemon[] data = new Pokemon[3];

//		while(i<data.length) {
//			System.out.print("포켓몬 이름 입력 : ");
//			String name = sc.next(); // 물어봐 줘야함; 이 포켓몬이름이 맞니??
//			System.out.print("포켓몬 레벨 입력 : ");
//			int lv = sc.nextInt();//문자열 입력 하면 에러. 음수 입력 하면 안됨.
//			data[0] = new Pokemon(name,lv);
//		}
		String name="";
		int lv = 0;
		System.out.println("===게임 실행====");
		
		for(int i =0; i<data.length;i++) {
			System.out.print((i+1)+"번째 캐릭터 '이름'을 입력 하세요 : ");
			name=sc.next();

			System.out.println("캐릭터이름을\""+name+"\""+"으로 정하시겠습니까?"
					+"\n Yes: 1, No: 2");
			int ans=sc.nextInt();
			if(ans!=1) {
				i--;
				continue;
			} 
			
			while(true) {
				System.out.print((i+1)+"번째캐릭터 '레벨'을 입력하세요 :" );
				lv=sc.nextInt();   
				
				
				
				if(lv<0) {
					System.out.println("잘못된 값 입니다.");
					continue;
				}
				else break;
			}
			data[i] = new Pokemon(name,lv);
		}
		System.out.println("플레이 시작");
		int i = 0;
//		while(true) {
//			data[i++].game();    
//			if(i==10) {
//				break;
//			}
//		}
		while(true) {
			for(int j = 0; j <data.length;j++) {
				data[j].game();
				data[j].printInfo();
			}
			if(i==10) {
				break;
			}
			i++;
		}
		
		
	}
}
