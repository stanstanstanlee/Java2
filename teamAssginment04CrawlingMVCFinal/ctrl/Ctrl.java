package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ShoppingDAO;
import model.ShoppingVO;
import view.View;

public class Ctrl {
   private ShoppingDAO sDAO;
   private MemberDAO mDAO;
   private View view;
   private MemberVO member; // 현재 로그인한 회원

   public Ctrl() {
      sDAO=new ShoppingDAO();
      mDAO=new MemberDAO();
      view=new View();
      member=null; // 아직 로그인 전이기때문에 null로 해준다.
   }
   public void startApp() {
      while(true) {
         int pAction=view.printProgramMsg();
         if(pAction==1) {  // 1번입력시 회원가입
            view.pStart(pAction);// 회원가입 실행
            if(mDAO.insert(view.createMember())) { 
               // view에서 회원정보를 받아, 
               // mDAO에 넘겨주고 insert실행
               view.pTrue(pAction); // 성공 문구
            }
            else {
               view.pFalse(pAction); // 실패 문구
            }
         }
         else if(pAction==2) {  // 2번입력시 로그인
            view.pStart(pAction); // 로그인 실행
            MemberVO mVO=view.login(); // view에서 로그인정보를 받아 mVO에 저장
            member=mDAO.selectOne(mVO); 
            // mVO를 이용해 mDAO에서 selectOne실행
            // 반환된 값을 member에 저장 ( 로그인한 회원의 정보 )
            if(member==null) { 
               view.pFalse(pAction);   // 로그인 실패 문구
               continue;    // 프로그램 모드에 계속 존재
            }
            view.pTrue(pAction); // 로그인 성공 문구
            //로그인 성공=======================================================================
            while(true){
               int cAction=view.printClientMsg();
               if( cAction ==1 ) { // 상품 목록출력
                  view.cStart(cAction); // 시작문구
                  ArrayList<ShoppingVO> datas=sDAO.selectAll(null); //null 입력시 전체목록 출력 
                  // sDAO에서 selectAll을 실행해
                  // 반환된값을 datas에 저장
                  view.printShoppingList(datas); // view를 통해 datas에 저장된값을 출력
               }
               else if ( cAction==2 ) { // 상품검색
                  while(true){
                     int sAction=view.printSearchMsg(); // 상품검색메뉴 출력
                     if(sAction==1) { // 이름검색
                        view.sStart(sAction); // 이름검색 시작 문구
                        String name=view.getName(); // 이름을 입력받아 name에 저장
                        ArrayList<ShoppingVO> datas=sDAO.selectAll(new ShoppingVO(0,name,0,0)); 
                        // 저장받은 이름으로 ShoppingVO에 만들고
                        // datas에 저장
                        view.printShoppingList(datas);
                        // datas에 들어가있는것 다 보여줘 
                     }
                     else if(sAction==2) { // 가격검색
                        view.sStart(sAction); // 가격검색 시작 문구
                        ShoppingVO sVO=view.getPrice();// view에서 ( 0, "필터검색", 최저가, 최고가 )를 입력받아 sVO에 저장
                        ArrayList<ShoppingVO> datas=sDAO.selectAll(sVO); // sVO를 통해 selectAll을 실행해 범위에 해당하는 값을 받아서 datas에 저장
                        view.printShoppingList(datas); // datas에 저장된것들 다 보여줘
                     }
                     else if(sAction==3) { // 판매량 제일 높은 상품
                        ArrayList<ShoppingVO> datas=sDAO.selectAll(new ShoppingVO(1,"최고검색",0,0)); 
                        // ShoppingVO의 PKnum을 1로 만들어 보내줘서 해당 if문에 들어갈수있도록 해줌
                        // sDAO에서 selectall을 진행해 datas에 저장
                        view.printShoppingList(datas);// datas에 저장된것들 다 보여줘
                     }
                     else{ // 검색메뉴 종료
                        view.sEnd(sAction);
                        break;
                     }
                  }
               }
               //==========================================================================
               else if ( cAction==3 ) { // 상품구매
                   view.cStart(cAction); // 상품 구매 시작문구
                   while(true) {
                      int num=view.getNum(); //번호 입력받아서 num에 저장
                      ShoppingVO data=new ShoppingVO(num,null,0,0);
                      // ShoppingVO에 num를 저장해서 sDAO에 selectOne를 실행 반환값을 data에 저장
                      if(sDAO.update(data)) { // data를 이용해 sDAO에서 update 실행
                         view.cTrue(cAction);
                         ShoppingVO sVO=sDAO.selectOne(data);
                         view.printShopping(sVO); // data의 이름과 가격을 사용자에게 보여줌
                         view.cEnd(cAction); // 구매완료 문구
                         break;
                      }
                      view.noItem();
                      continue;
                   }
                }
               //========================================================================
               else if ( cAction==4 ) { // 회원 탈퇴
                  view.cStart(cAction); // 회원탈퇴 시작문구
                  String mpw=view.getPassword(); // view를 통해 비밀번호를 입력받아 mpw에 저장
                  if(member.getMpw().equals(mpw)) { // 현재 로그인한 사람의 비밀번호와 mpw가 같은지 검사 
                     if(mDAO.delete(member)) { // 같다면 현재 로그인한 사람의 데이터로 mDAO에서 delete실행
                        view.cTrue(cAction); // 성공한다면 회원탈퇴 안내문구
                        break;
                     }
                  }
                  view.cFalse(cAction); //실패한다면 실패문구
               }
               //==========================================================================
               else if ( cAction==5 ) { // 회원정보 변경
                  while(true) {
                     int uAction=view.printUpdateMsg(); // 회원정보 변경 메뉴 출력
                     if(uAction==1) { // 이름변경
                         view.uStart(uAction); // 이름변경 시작 문구
                         String mpw=view.getPassword(); // 현재 비밀번호 입력 받아 mpw에 저장
                         if(member.getMpw().equals(mpw)) { // 현재 로그인한(member)의 비밀번호와 mpw가 같으면 진행
                            String newName=view.getNewName(); // 사용자에게 변경하고 싶은 새로운 이름을 입력받아 newName에 저장
                            MemberVO mVO1=new MemberVO(member.getMid(),"이름 변경",newName); // searchcondition을 사용 
                            if(mDAO.update(mVO1)) { // 저장된 mVO1을 사용해 mDAO의 updata를 실행 성공한다면
                               view.uTrue(uAction); // 이름변경 성공문구 
                            }
                            else {
                               view.uFalse(uAction);// 실패시 실패문구
                            }
                         }
                         else {
                            view.uFalse(uAction);// 실패시 실패문구
                         }
                      }
                      else if(uAction==2) { // 비밀번호 변경
                         view.uStart(uAction);// 비밀번호 변경 시작 문구
                         String mpw=view.getPassword(); // 현재 비밀번호 입력 받아 mpw에 저장
                         if(member.getMpw().equals(mpw)) { // 현재 로그인한(member)의 비밀번호와 mpw가 같으면 진행
                            String newMpw=view.getNewPassword(); // 사용자에게 변경하고 싶은 새로운 비밀번호을 입력받아 newMpw에 저장
                            MemberVO mVO1=new MemberVO(member.getMid(),newMpw,"비번 변경"); // searchcondition을 사용 
                            if(mDAO.update(mVO1)) { // 저장된 mVO1을 사용해 mDAO의 updata를 실행
                               view.uTrue(uAction); // 비밀번호 변경 성공문구 
                            }
                            else {
                               view.uFalse(uAction);// 실패시 실패문구
                            }
                         }
                         else {
                            view.uFalse(uAction);// 실패시 실패문구
                         }
                      }
                     else if(uAction==3) { // 개인정보 출력
                        MemberVO mVO1=new MemberVO(member.getMid(),member.getMpw(),member.getmName());
                        // mVO1에 현재 로그인한 회원의 ( 아이디, 비밀번호, 이름)을 저장해서
                        view.printMember(mDAO.selectOne(mVO1));
                        // mVO1을 사용해 mDAO에서 selectOne를 실행해 반환된 정보를
                        // view를 통해 사용자에게 보여줌
                     }
                     else{ // 회원정보변경 메뉴 종료
                        view.uEnd(uAction);
                        break;
                     }
                  }
               }
               else { // 6번입력시 종료
                  view.cEnd(cAction);
                  break;
               }
            }
         }
         else { // 3번입력시 프로그램 종료
            view.pEnd(pAction);
            break;
         }
      }
   }
}