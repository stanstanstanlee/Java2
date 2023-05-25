package model;

import java.util.ArrayList;
// DAO의 CRUD(비지니스 메서드, 핵심로직)는 한번 제작 되면 그 이후에 어떤 추가 요청사항이 와도 
// 절대!
// "메서드 시그니처"가 변하기 않도록 코드를 작성해야함!!!

// "메서드 시그니처"가 변경되면 다른 파트에 영향을 줘버림
// '기능'구현 변경은 괜찮;
// 결론 : "메서드 시그니처"는 설계단계에서 절대로 변경되면 안됨!!

public class DrinkDAO {

   private static int PK=1001;
   private ArrayList<DrinkVO> datas;
   public DrinkDAO() {
	   this.datas=new ArrayList<DrinkVO>();
	   this.datas.add(new DrinkVO(PK++,"콜라",1200,3));
	   this.datas.add(new DrinkVO(PK++,"사이다",900,2));
	   this.datas.add(new DrinkVO(PK++,"환타",1500,1));
   }

   public boolean insert(DrinkVO vo) {
	   System.out.println("MODEL(DAO): vo: "+vo);
		datas.add(new DrinkVO(PK++,vo.getName(),vo.getPrice(),vo.getCnt()));
		return true;
   }
   							//내꺼 그냥 보여줘야 할때도 있고 검색결과를 새로 만들어서 보여줘야 할때도 있음
   public ArrayList<DrinkVO> selectAll(DrinkVO vo) {//메서드 시그니처를 바꾸면 이걸 쓰는 외부에서 문제가 생김 
	   //내부는 바뀌어도 됨; 외부에 영향 안줌
	   if(vo.getName() == null) {//전체목록출력
		   return this.datas;
	   }
	   else {
//		   이름을보고,
//		   새로운 datas를 만들어서,
//		   이름을 가진 애들을 넣어서 반환
		   ArrayList<DrinkVO> datas=new ArrayList<DrinkVO>();
		   for(DrinkVO data:this.datas) {
			   if(data.getName().contains(vo.getName())) {//검색이름이 data이름에 존재해?
				  datas.add(data); 
			   }
		   }
		   return datas;
	   }
	   //1. 전체목록출력 => 그냥 내가가진 멤버변수 dataㄴ 반환
	   //2. 검색결과출력 => 이름을보고, 그 이름을 가진 애들을 반환
   }
   public DrinkVO selectOne(DrinkVO vo) { //PK
	   for(DrinkVO data : this.datas) {
		   if(data.getNum()==vo.getNum()) {
			   DrinkVO dVO=new DrinkVO(data.getNum(),data.getName(),data.getPrice(),data.getCnt());
			   return dVO; //실제 DB데이터(==datas)를 전송 하면 안되고
			   //새로 vo객체를 new(객체화)해서 전송해야함
			   //return data; 하면 업데이트가 된 후 다시 (컨트롤러에있던) 'int cnt = 1 -> data.setCnt(cnt); '때문에 기존 데이타가 1로 돌아가버림. 
		  
		   /*
		       public DrinkVO selectOne(DrinkVO vo) { // PK
      				for(DrinkVO data:datas) {
         				if(data.getNum()==vo.getNum()) {
            		return data;
         			}
      			}

		    */
		   
		   }
	   }
	   System.out.println("로그 : selectOne(): 해당상품없음");
	   return null;
   }
   //오버로딩이 불가능한 기능일 경우,
   // 기능이 매우 유사한 것이기때문에 내부로직에서 분리하여 관리 
   // -> 유사한 기능끼리는 묶어서 관리하는 것이 용이하기 때문
   // 	== 응집도를 높임 -> 유지보수에 용이 
   public boolean update(DrinkVO vo) { //인자를 vo로받으면 결합도가 낮아지고 유사한 기능끼리 묶어놓으면 응집도를 높임 
	   for(DrinkVO data : this.datas) {
		   if(data.getNum()==vo.getNum()) {//찾았어??
			   // 구매할때에는 절대값이랑 내 재고랑 비교
			   if(vo.getCnt()<0) { //구매할때
				   int cnt = vo.getCnt()*(-1); //구매하려는 양
				   if(cnt<=data.getCnt()) {
					   System.out.println("로그 : update() : 재고 없음");
					   return false;
				   }
				   data.setCnt(data.getCnt()+vo.getCnt());
				   return true;
			   }
			   System.out.println("로그 : update(): 해당상품없음");
			   
//			   if(data.getCnt()>=vo.getCnt()) { //재고가 음수면 뺄 수 없음
//				   				 //기존재고
//				   data.setCnt(data.getCnt()+vo.getCnt());//마이너스시킬예정 
//				   data.setCnt(data.getCnt()-vo.getCnt());//보통 여기가 +vo임 그리고 컨트롤러에서 구매하면 깎아서 보냄
//			   }
//			   return true;
//			   System.out.println(" 로그: update(): 재고없음");
//			   return false;
		   }
	   }
	   System.out.println("로그 : update(): 해당상품없음");
	   return false;
   }
   
   public boolean delete(DrinkVO vo) {
	   for(int i =0; i<this.datas.size();i++) {
		   if(this.datas.get(i).getNum()==vo.getNum()) {//찾았어??
			   this.datas.remove(i);
			   return true;
		   }
	   }
	   System.out.println("로그 : remove(): 해당상품없음");
	   return false;

   }
   
   
}