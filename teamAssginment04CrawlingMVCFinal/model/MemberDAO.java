package model;
import java.util.ArrayList;

//회원목록출력
//회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
   private ArrayList<MemberVO> datas;
   //=============================생성자======================
   public MemberDAO() {
      datas=new ArrayList<MemberVO>();

   }
   //R 가입자 목록 출력 (이름)    selectAll
   public ArrayList<MemberVO> selectAll(MemberVO mVO){
      return datas;
   }
   //R 로그인 할 떄 가입자 아이디 일치 하는지 확인 후 비밀번호 확인  selectOne

   public MemberVO selectOne(MemberVO mVO){
      for(MemberVO v:datas) {
         if(mVO.getMid().equals(v.getMid())) {
            if(mVO.getMpw().equals(v.getMpw())) {
               return v;
            }
            return null;
         }
      }
      return null;
   }
   //C 회원가입   insert
   public boolean insert(MemberVO mVO) {
      boolean flag=false;
      for(MemberVO data:datas) {
         if(data.getMid().equals(mVO.getMid())) {//신규 가입자가 입력한 아이디가 중복 아닌지 확인; 
            flag=true;
            break;
         }
      }
      if(flag) {
         return false;
      }
      else {
         datas.add(new MemberVO(mVO.getMid(),mVO.getMpw(),mVO.getmName()));
      }
      return true;
   }
   //U 가입자의 정보를 데이터와 확인 후 사용자가 입력한 새로운 비밀번호로 비밀번호 변경    update
   public boolean update(MemberVO mVO) {
      if(mVO.getmName().equals("비번 변경")) {
         for(MemberVO v:datas) {
            if(v.equals(mVO)) {
               v.setMpw(mVO.getMpw());
               return true;
            }
         }
      }
      if(mVO.getMpw().equals("이름 변경")) {
         for(MemberVO v:datas) {
            if(v.equals(mVO)) {
               v.setmName(mVO.getmName());
               return true;
            }
         }
      }
      return false;
   }
   //D 가입자 회원정보를 member로 전달받아서 datas에 있는 정보인지 확인후 일치하면 remove를 통해 삭제
   public boolean delete(MemberVO mVO) {
      for(int i=0;i<datas.size();i++) {
         if(datas.get(i).equals(mVO)) {
            datas.remove(i);
            return true;
         }
      }
      return false;
   }
}