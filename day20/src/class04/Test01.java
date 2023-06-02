package class04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 웹 크롤링
public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> brand = new ArrayList<String>();
		ArrayList<String> itemName = new ArrayList<String>();
		ArrayList<String> price = new ArrayList<String>();

		// 1. 웹 페이지 코드를 JAVA로 가져오기
		final String url="https://search.musinsa.com/ranking/best?u_cat_cd=";

		
		//  a) 해당 url의 페이지 코드를 받아오기위해, 연결통로(스트림)를 open해야함
		//     == connect()해야함
		Connection conn=Jsoup.connect(url);
		// Scanner,Random,ArrayList,... => JAVA에서 기본적으로 제공하는 클래스
		// Jsoup => JAVA에서 기본제공 xxx

		//  b) connect()가 정상적으로 수행되었다면, get()(getter)을 통하여
		//     해당 페이지의 코드를 받아옴
		Document doc=null;
		try {
			doc=conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. 페이지 스크랩핑 완료
		//System.out.println(doc);

		// 3. 페이지 코드를 분석
		//  a) DOM 문서를 분석
		//     <></> 태그(요소,element) 단위로 분석
		//     속성(property)을 가질수있으며,
		//      분석할때에 가장 대표적으로 활용되는 속성이
		//      id(유일한 요소), class(여러개의 공통점을 가진 요소들)
		Elements elems=doc.select("p.item_title>a");
		Elements elems2=doc.select("p.list_info>a");
		Elements elems3=doc.select("p.price");
		// 태그명#id명
		// 태그명.class명
		// 상위태그명 > 하위태그명
		//  => 파싱
		//확인
//		System.out.println(elems);

		// 4. 분석하여 추출완료한 데이터를 console 화면에 출력
		// Iterator 이터레이터
		//  : 거대한 컬렉션(elems)에 있는 데이터를 작은 단위의 컬렉션(elem)으로 나눠저장할수있도록 해주는 컬렉션
		Iterator<Element> itr=elems.iterator();
		Iterator<Element> itr2=elems2.iterator();
		Iterator<Element> itr3=elems3.iterator();
		// itr는 hasNext(),next()
		//      다음 요소가 있어?,그럼 다음거(==내거,<제네릭>에 해당하는 자료형)보여줘~

		int idx = 0;
		
		while(true) {
			String str,str2,str3;
			try {
			 str = itr.next().toString();
			 str2 = itr2.next().toString();
			 str3 = itr3.next().toString();
			}
			catch(Exception e) {
				break;
			}
			// 5. 데이터를 가공
			int index = str.indexOf(">"); //자를 위치
			str = str.substring(index+1); // 앞 자름
			index=str.indexOf("<"); //뒤 자를 위치
			str = str.substring(0, index);
			if(str.isBlank()) {
				continue;
			}
			idx++;
			brand.add(str);
//		System.out.println(brand);
//		System.out.println(idx);

			// 5. 데이터를 가공
			int index2 = str2.indexOf(">"); //자를 위치
			str2 = str2.substring(index2+1); // 앞 자름
			index2=str2.indexOf("<"); //뒤 자를 위치
			str2 = str2.substring(0, index2);
			if(str2.isBlank()) {
				continue;
			}
			idx++;
			itemName.add(str2);
//		System.out.println(itemName);
//		System.out.println(idx);

			// 5. 데이터를 가공
			int index3 = str3.indexOf(">"); //자를 위치
			str3 = str3.substring(index3+1); // 앞 자름
			index3=str3.indexOf("<"); //뒤 자를 위치
			str3 = str3.substring(0, index3);
			if(str3.isBlank()) {
				continue;
			}
			idx++;
			price.add(str3);
			System.out.println(str);
			System.out.println(str2);
			System.out.println(str3);
//		System.out.println(price);
//		System.out.println(idx);
//		for(int j=0; j<price.size();j++) {
//			System.out.print(brand.get(j)+" + ");
//			System.out.print(itemName.get(j)+" + ");
//			System.out.println(price.get(j));
//		}
	}
	}
}