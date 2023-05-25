package class04;

class CarB{
   String name;
   int speed;
   int max;

   // this() == 생성자 함수
   CarB(){
      this("무명",120);
      System.out.println("확인 1");
   }
   CarB(String name){
      this(name,120);
      System.out.println("확인 2");
   }
   CarB(String name,int max){
      this.name=name;
      this.speed=0;
      this.max=max;
      System.out.println("확인 3");
   }

   void printInfo() {
      System.out.println(this.name+"님의 차는 ["+this.speed+"/"+this.max+"]입니다.");
   }
   void speedUp() {
      this.speed+=100;
      if(this.speed>this.max) {
         this.speed=this.max;
         System.out.println("과속!");
      }
   }
   void speedUp(int speed) { // 오버로딩
      this.speed+=speed;
      if(this.speed>this.max) {
         this.speed=this.max;
         System.out.println("과속!");
      }
   }
   void speedDown() {
      this.speed-=5;
      if(this.speed<=0) {
         this.speed=0;
         System.out.println("정지...");
      }
   }
}
public class Test05CarAnswer02 {

   public static void main(String[] args) {
      
      CarB c1=new CarB(); // 53->9->10 => 17~22 =>11
      CarB c2=new CarB("홍길동"); //54->13->14=>17~22->15
      CarB c3=new CarB("아무무",200);
      
      c1.printInfo();
      c2.speedDown();
      c2.printInfo();
      c3.speedUp();
      c3.speedUp(50);
      c3.printInfo();
      c3.speedUp(70);
      c3.printInfo();
      
      
      
      
      
      
      
      
      
      
      
      
   }

}