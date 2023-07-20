package model;

public class MemberVO {

   private String mid;//pk 사용자 아이디
   private String mpw;//비밀번호
   private String mName;//사용자 이름
   
   public MemberVO(String mid,String mpw,String mName) {
      this.mid=mid;
      this.mpw=mpw;
      this.mName=mName;

   }

   public String getMid() {
      return mid;
   }

   public void setMid(String mid) {
      this.mid = mid;
   }

   public String getMpw() {
      return mpw;
   }

   public void setMpw(String mpw) {
      this.mpw = mpw;
   }

   public String getmName() {
      return mName;
   }

   public void setmName(String mName) {
      this.mName = mName;
   }
   @Override
   public boolean equals(Object obj) {      
      // 아이디(mid)가 같다면, 같은객체!
      MemberVO mVO=(MemberVO)obj;
      if(this.mid.equals(mVO.mid)) {
         // PK값이 같다면, 동일한 객체이다!!!
         return true;
      }
      return false;
   }
   
   @Override
   public String toString() {
      return this.mid+"님의 \n 비밀번호 :"+this.mpw+"\n 사용자의 이름 :"+this.mName;
   }







}