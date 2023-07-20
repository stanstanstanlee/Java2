package model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
   public static ArrayList<ShoppingVO> sample(){//크롤링위해 sample() 메서드 만듬
      //쿠팡 상품목록 페이지 
      final String url="https://pages.coupang.com/p/89143?from=home_C1&traid=home_C1&trcid=11262476";
      // 불러오는 페이지 
      Connection conn=Jsoup.connect(url);
      // 페이지 불러온걸 연결시킴
      Document doc=null;
      try {
         doc=conn.get();
      } catch (IOException e) {
         e.printStackTrace();
      }
      // 해당페이지 받아와서 try-catch
      Elements elems=doc.select("span.info_section__title");
      // 파싱
      // elems에 저장
      Iterator<Element> itr=elems.iterator();
      // Iterator를 사용해서 elems를 나뉘어서 저장
      
      Elements elems1=doc.select("span.price_info__discount");
      
      Iterator<Element> itr1=elems1.iterator();
      
      ArrayList<ShoppingVO> datas=new ArrayList<ShoppingVO>();
      int PK=1001;
      
      while(itr.hasNext() && itr1.hasNext()) {
         String str=itr.next().toString();// String으로 변환시켜줌    [상품이름]
         int index=str.indexOf(">");
         str=str.substring(index+1);
         index=str.indexOf("<");
         str=str.substring(0,index);
         
         String str1=itr1.next().toString();  // String으로 변환시켜줌    [상품가격]  
         int index1=str1.indexOf(">");
         str1=str1.substring(index1+1);
         index1=str1.indexOf("<");
         str1=str1.substring(0,index1);
         // String값이 10,300이런식으로 나와서 ,때문에 인트값 변환시켜줄수없음
         String str2=str1.replace(",",""); // 구글 검색 으로 찾음,을 없애줌
         int price = Integer.parseInt(str2);//스트링값(가격)을 인트값으로 변환시켜줌
        
         //ex) 어뮤즈키친 오로라 월드와인 2p, 350ml, 1세트의 가격 :10320원
         
         datas.add(new ShoppingVO(PK++,str,price,0));   //형 변환된 값 ShoppingVO datas에 저장 
      }
      return datas;
      
   }
}