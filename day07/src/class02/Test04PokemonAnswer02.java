package class02;

import java.util.Random;
import java.util.Scanner;

class Pokemon3{
   String name;
   int lv;
   int exp;
//   Pokemon3(){
//      Scanner sc=new Scanner(System.in);
//      System.out.print("이름입력) ");
//      this.name=sc.next();
//      System.out.print("레벨입력) ");
//      this.lv=sc.nextInt();
//      Random rand=new Random();
//      this.exp=rand.nextInt(11);
//
//   }
   Pokemon3(String name,int lv,int exp){
      this.name=name;
      this.lv=lv;
      this.exp=exp;
   }
   void printInfo() {
      System.out.println(this.name+" Lv."+this.lv+"["+this.exp+"/100]");
   }
   void game() {
      Random rand=new Random();
      int randNum=rand.nextInt(2);
      if(randNum==0) {
         this.exp+=rand.nextInt(101)+50;
         System.out.println("성공!");
      }
      else {
         this.exp+=10;
         System.out.println("실패...");
      }

      while(this.exp>=100) {
         System.out.println(this.name+", 레벨업!");
         this.lv++;
         this.exp-=100;
      }
   }
}

public class Test04PokemonAnswer02 {
   public static void main(String[] args) {

      Pokemon3[] data=new Pokemon3[2];
//      data[0]=new Pokemon3();

      Scanner sc=new Scanner(System.in);

      String name;
      while(true) {
         System.out.print("이름입력) ");
         name=sc.next();
         
         System.out.print("이게맞나요?(1-YES,2-NO) ");
         int action=sc.nextInt();
         if(action==1) {
            break;
         }
      }
      System.out.print("레벨입력) ");
      int lv=sc.nextInt();
      Random rand=new Random();
      int exp=rand.nextInt(11);
      data[1]=new Pokemon3(name,lv,exp);

      int i=0;
      while(true) {

         for(int j=0;j<data.length;j++) {
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