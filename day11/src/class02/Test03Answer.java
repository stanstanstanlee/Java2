package class02;

// class Pokemon
//  - String name
//  - int win 이긴횟수
//  - void hello() : 각각의 포켓몬마다 고유한 소리를 출력
//  - boolean game(Pokemon pokemon)
//      -> pokemonA.game(pokemonB);
//         이긴횟수가 홀홀 작은값이 이김
//         이긴횟수가 짝짝 큰값이 이김
//          동일하다면 A가 이김(A>B)
//         이긴횟수가 홀짝,짝홀 홀수가 이김

// class 생성시
// 1. abstract일까?
//    1) 이 클래스의 객체가 필요한가?
//    2) 추상메서드가 있나? == 오버라이딩을 강제해야하는 메서드가 있나?
//         == 재정의해야하는 메서드가 있나?
// 2. 멤버변수 생성
//    1) private
//    2) getter,setter
// 3. 생성자
// 4. 메서드
//    1) 오버라이딩(재정의)을 강제해야되나? => 추상메서드로 만들어야하나?
//    2) '기능'을 보고, "INPUT,OUTPUT"을 생각하여 '메서드 시그니처' 작성
abstract class Pokemon{
   private String name;
   private int win;
   
   Pokemon(String name){ // 추상클래스 생성자 소유 가능
      this.name=name;
      this.win=0;
   }
//   Pokemon() {
//	   
//   }
   
   abstract void hello();

   boolean game(Pokemon pokemon) {
      if(this.win%2==1 && pokemon.win%2==1) {
         if(this.win<=pokemon.win) {
            this.win++;
            return true;
         }
         else {
            pokemon.win++;
            return false;
         }
      }
      else if(this.win%2==0 && pokemon.win%2==0) {
         if(this.win>=pokemon.win) {
            this.win++;
            return true;
         }
         else {
            pokemon.win++;
            return false;
         }
      }  
      else {
         if(this.win%2==1) {
            this.win++;
            return true;
         }
         else {
            pokemon.win++;
            return false;
         }
      }
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

class Pika extends Pokemon{
   Pika() {
      super("피카츄");
   }
   
   Pika(String name ){
	   super(name);
   }
   
   @Override
   void hello() {
      System.out.println("피카피카");
   }
   // 1. 메서드 안만든거 있어~~ => 오버라이딩 강제되고있는 메서드(추상메서드)
   //    => 1. 나도 추상클래스 하던지
   //       2. 추상메서드 오버라이딩 해주던지 ◀
   // 2. super()를 호출하는 중이야~~ => 부모클래스에게는 기본생성자가 현재 없음
   //    => 1. 부모클래스에 기본생성자 만들던지
   //       2. 부모클래스의 다른생성자를 사용하던지 ◀
}
class Metamon extends Pokemon{
   Metamon() {
      super("메타몽");
   }
   @Override
   void hello() {
      System.out.println("˚▽˚");
   }  
}

public class Test03Answer {
   public static void main(String[] args) {
      Pika pika=new Pika();
      Metamon m1=new Metamon();
      Metamon m2=new Metamon();
      
      pika.setWin( pika.getWin()+1 ); // == pika.win++;
      
      pika.game(m1);
      System.out.println(pika.getWin());
      m2.game(pika);
      System.out.println(pika.getWin());
      m1.game(pika);
      System.out.println(pika.getWin());
      m1.game(m2);
      System.out.println(m1.getWin());
      pika.game(m1);
      System.out.println(m1.getWin());
     
      m1.hello();
     
   }
}