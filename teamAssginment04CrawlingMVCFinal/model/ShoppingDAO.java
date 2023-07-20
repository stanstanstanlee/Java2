package model;

import java.util.ArrayList;

/*
 */
public class ShoppingDAO {
   //[멤버변수]
   ArrayList<ShoppingVO> datas;
   //[생성자] 
   public ShoppingDAO () {
      //크롤링해서 가져올거임 
      this.datas=Crawling.sample();//크롤링 한 데이터 smple()메서드 통해서 data에 대입 
   }

   //[메서드]=====================================================================


   public ArrayList<ShoppingVO> selectAll(ShoppingVO sVO) {
      //전체출력
      if(sVO==null) {
         return datas;
      }
      //가격검색 -필터검색  
      else if(sVO.getName().equals("필터검색")) { // searchCondition
         ArrayList<ShoppingVO> mdatas=new ArrayList<ShoppingVO>();
         for(ShoppingVO data:datas) {
            if(sVO.getPrice() <= data.getPrice() && data.getPrice() <= sVO.getCnt())  {
               mdatas.add(data);//가격 최저 최고 사이  view 에서 잘못입력해도 바꿔주는 메서드 있음
            }
         }
         return mdatas;  // 입력한 가격 사이에 있는 상품들 반환해줌
      }
      else if(sVO.getNum()==1) {
         ArrayList<ShoppingVO> mdatas=new ArrayList<ShoppingVO>();
         int mcnt=0; // 최고구매횟수
         int maxIndex=0;//최고구매상품 번호
         for(int i=1;i<datas.size();i++) {
            if(datas.get(maxIndex).getCnt()<datas.get(i).getCnt())  {
               maxIndex=i;
            }//최대값 구해서 
         }
         mcnt=datas.get(maxIndex).getCnt();//maxIndex에 해당하는 구매횟수를 mcnt에 저장 
         
         for(ShoppingVO data:datas) {
            if(mcnt==data.getCnt())  {//mcnt랑 같은 구매횟수를 가진 모든 데이터를 비교하여 같으면 추가한다.
               mdatas.add(data);
            }
         }
         return mdatas;//변경된 데이터 반환
      }
      else {
         // pVO가 null이 아니라면 '이름으로검색'임!
         ArrayList<ShoppingVO> mdatas=new ArrayList<ShoppingVO>();
         for(ShoppingVO data:datas) {
            if(data.getName().contains(sVO.getName())) {//검색한 단어 포함되면 그 데이터 mdatas에 저장후 반환해준다.
               // sVO.getName) == 사용자가 검색한 단어
               mdatas.add(data);
            }
         }         
         return mdatas;
      }
   }

   //구매성공시 구매한 품목 출력 메서드
   public ShoppingVO selectOne(ShoppingVO sVO) {
      for(ShoppingVO data:datas) {
         if(data.getNum()==sVO.getNum()) {
            ShoppingVO s2VO=new ShoppingVO(data.getNum(),data.getName(),data.getPrice(),data.getCnt());            
            return s2VO;
            // 실제 DB 데이터(==datas)를 전송 xxxxx
            // 새로 vo객체를 new(객체화)해서 전송 O
         }
      }
      return null;
   }

   //기능 : 크롤링해서 가져옴 
   //크롤링해서 데이터 가져오기 때문에 필요없는 기능
   public boolean insert(ShoppingVO sVO) {
      return false;
   }

   //기능 : 구매할때 마다 해당 제품 구매수++
   //구매시 구매횟수 1개씩 올려주는 메서드 
   public boolean update(ShoppingVO sVO) {

      //- 구매할때 그 상품 ++
      for(int i =0; i<datas.size();i++) {// : 나의 상품데이터 전체 반복비교.
         if(datas.get(i).getNum()==sVO.getNum()) {// : 상품구매
            int cnt=datas.get(i).getCnt();//해당상품의 구매횟수를 cnt에 대입
            cnt++;//그걸 ++;==>새로운 구매횟수
            datas.get(i).setCnt(cnt);//새로운 구매횟수로 set
            return true;
         }
      }
      return false;
   }

   //크롤링해서 데이터 가져오기 때문에 필요없는 기능
   public boolean delete(ShoppingVO sVO) {
      return false;
   }

}