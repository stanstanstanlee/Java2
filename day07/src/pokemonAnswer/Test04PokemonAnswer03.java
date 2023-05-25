package pokemonAnswer;

import java.util.Random;
import java.util.Scanner;

//포켓몬 클래스가 있습니다.
//이 클래스로 포켓몬 객체들을 생성할겁니다.
//포켓몬 객체들을 3마리 저장할예정입니다. >> "이름과 레벨은 사용자로부터 입력받고, 경험치는 0~10중에서 랜덤생성"
//포켓몬은 이름,레벨,경험치가 있습니다.
//po.printInfo(); --> 객체명 po
//   -> 피카츄 Lv5. [5/100]
//프로그램을 무한하게 동작시킬예정입니다. --> while
//각각의 포켓몬 객체들은 game()을 진행합니다.
//경험치가 100이될때마다 레벨은 1씩 증가합니다.
//   레벨 1 증가시, "피카츄, 레벨업!" 문장을 출력해주세요.
//po.game(); ==> 승패는 반반
//   -> 성공시 경험치가 50~150중에서 랜덤만큼 증가
//   -> 실패시 경험치가 10증가
//+) po.game()을 순서대로 동작시키는 방법
//+++) po.game()을 입력받아서 동작시키는 방법

// 정리
// 클래스명 포켓몬
// 멤버변수
// - 인스턴스 변수 : 이름, 레벨, 경험치
// - 클래스 변수 : 최대경험치, 최대레벨(?)
// 메서드
// - 인스턴스 메서드 : 객체정보 출력, 게임메서드(경험치), 레벨업 메서드(출력포함)
//게임
// 성공 , 실패
// 성공 = 경험치 랜덤, 성공출력
// 실패 = 경험치 10, 실패출력
// 레벨업 메소드 = ㅁㅁㅁㅁㅁ
// 객체생성 : 3마리
// 객체명 : po
// 반복문 : while
// +추가
// 두개의 캐릭터를 배틀해서 승패를 나누고 결과 출력

class Pokemon {

   String name; // 이름
   int lev; // 레벨
   int exp; // 경험치
   static int maxExp = 100; // 최대경험치
//   static int maxLev = 100; // 포기한거
   
   
   public Pokemon() {
      Scanner sc = new Scanner(System.in);
      System.out.print("이름입력 : ");
      this.name = sc.nextLine(); // 이름설정
      
      System.out.print("레벨 입력 : ");
      this.lev = sc.nextInt(); // 레벨설정
      sc.nextLine();
      
      this.firstExp(); // 경험치 설정
//      this.printInfo(); // 상태창 출력 ->> 모든 입력받고 따로 출력으로 바뀜
      
      sc.close();
   }

   public Pokemon(int num) {
      this("아르세우스", num); // 이스터 에그 -> 나올수 없는...
   }

   public Pokemon(String name) {
      this(name, 100); // 이스터 에그 반쪽짜리 -> 나올수 없는...
   }

   public Pokemon(String name, int lev) {
      this.name = name; // 이름설정
      this.lev = lev; // 레벨설정
      this.firstExp(); // 경험치 설정
//      this.printInfo(); // 상태창 출력 ->> 모든 입력받고 따로 출력으로 바뀜
   }

   void printInfo() { // 상태창 메서드
      System.out.println(this.name + " Lv." + this.lev + " [" + this.exp + "/" + Pokemon.maxExp + "]");
   }

   void firstExp() { // 초기 경험치 생성
      Random rand = new Random();
      this.exp = rand.nextInt(11);
   }

   void expUp(int exp) { // 경험치 추가
      this.exp += exp;

      if (this.exp >= (Pokemon.maxExp * 2)) { // 경험치가 과해서 2랩만큼일 경우
         this.levUp();
         this.levUp();
      } else if (this.exp >= Pokemon.maxExp) { // 정상적인 레벨업
         this.levUp();
      }
   }
   
   // 강사님 풀이
//   void expUp(int exp) { // 경험치 추가
//      this.exp += exp;
//      
//      while (this.exp > Pokemon.maxExp) { // 경험치가 경험치 바 안에 들어갈 때까지
//         this.levUp();
//      }
//   }

   void levUp() { // 경험치가 꽉차서 레벨업하는 메서드
      System.out.println("레벨 업!"); // 레벨업 출력
      this.lev++; // 레벨증가
      this.exp -= 100; // 경험치 감소
   }

   void game() { // 게임
      Random rand = new Random(); // 랜덤객체
      if (rand.nextInt(2) == 0) { // 성공여부
         System.out.println("패배...");
         this.expUp(10);
         this.printInfo(); // 게임 후 상태창 출력
      } else {
         System.out.println("승리!");
         this.expUp(rand.nextInt(101) + 50); // 경험치 랜덤증가
         this.printInfo();
      }
   }

   void battle() { // 구성고민중
      // 대충 캐릭터 리턴
      // 메인 안에서 구성해야할거같은데?
   }

}

public class Test04PokemonAnswer03 {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      Pokemon[] po = new Pokemon[3];
//      po[0] = new Pokemon("피카츄"); // -> 100렙짜리 피카츄
//      po[1] = new Pokemon("루카리오");
//      po[2] = new Pokemon("다크라이");
//      po[0] = new Pokemon(); // -> 100렙짜리 아르세우스

      System.out.println("입력받는 포켓몬게임~");
      System.out.println("레벨과 경험치는 장식입니다");
      System.out.println("모든 결과는 랜덤이에요~");
      System.out.println("세마리의 포켓몬을 입력해주세요");
      System.out.println("이름은 자유입니다(개발자 헛소리:이름은 도저히 유효성검사를 할수가 없어....)");
      System.out.println("레벨은 음수나 0만 아니면 됩니다(제한없음)");

      for (int i = 0; i < po.length; i++) { // 반복
         System.out.println("이름을 입력해주세요");
         String name = sc.nextLine();
         int level = 0;

         System.out.println(name + "(으)로 하시겠습니까?");
         System.out.println("긍정이면 1을 입력해주세요");
         int tmp = sc.nextInt();
         sc.nextLine();

         if (tmp != 1) {
            System.out.println("다시 입력해주세요");
            i--;
            continue;
         }

         while (true) {
            System.out.println("레벨을 입력해주세요");
//         System.out.println("경고 : 이상하게 입력하면 이름부터 다시 입력해야합니다"); // 아몰라 힘들어 난 경고했어 지못미
            
            level = sc.nextInt();
            sc.nextLine();

//         if (level <= 0) { // 레벨 유효성 검사
//            System.out.println("잘못입력하셨습니다");
//            System.out.println("다시 입력해주세요");
//            i--; // 횟수감소
//            continue;
//         }
            
            if (level >= 0) {
               break;
            }
            System.out.println("잘못입력하셨습니다");
            System.out.println("다시 입력해주세요");
         }

         po[i] = new Pokemon(name, level); // 저장
         System.out.println("입력되었습니다");
      }

      System.out.println("모든 입력이 완료되었습니다");
      // 정보출력
      for (int i = 0; i < po.length; i++) {
         po[i].printInfo();
      }

      while (true) {

         System.out.println();
         System.out.println("게임을 플레이할 캐릭터를 선택하세요");
         for (int i = 0; i < po.length; i++) {            
            System.out.println((i+1) + ". " + po[i].name);
         }
         System.out.print("숫자입력 : ");

         int sel = sc.nextInt()-1;
         sc.nextLine();

         if (sel < -1 || sel > 2) { // 유효성 검사
            System.out.println("잘못입력하셨습니다");
            continue;
         } else if (sel == -1) { // 종료
            System.out.println("게임을 종료합니다");
            break;
         }

         System.out.println(po[sel].name + "으로 게임을 합니다");
         po[sel].game();

      }

      sc.close(); // 스캐너 종료
   } // main
}