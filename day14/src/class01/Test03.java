package class01;
/*
가족 공동 계좌
10000원
가족들은
5000원씩 사용
가족 구성원은 3명
이때, 결제에 실패한 가족의 이름을
console에 출력!
 */
class Family extends Thread {
	Account a = new Account();//?????

	// thread.start() -> run()메서드가 수행
	@Override
	public void run() {
		super.run();
		a.spend();
	}
	
}

class Account {
	static int money = 10000; //공동계좌 공유자원
	static int spending = 5500;
	synchronized void spend() {
		if(money >=spending) {	//1)스레드가 멤버변수로 Name을 갖고 있다; 2)Thread t1 = new Thread(f,"Name"); <<Name자리이다
			System.out.println(Thread.currentThread().getName()+" 결제 성공"); 
			money-=spending;
		}
		else {
			System.out.println(Thread.currentThread().getName()+" 결제 실패");
		}
		System.out.println("남은 돈 "+money);
	}
}

public class Test03 {
	public static void main(String[] args) {
	
		Family f = new Family();
		Thread t1 = new Thread(f,"홍길동");
		Thread t2 = new Thread(f,"아무무");
		Thread t3 = new Thread(f,"티모");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
