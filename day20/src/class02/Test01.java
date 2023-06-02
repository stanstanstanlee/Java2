package class02;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 웹 크롤링
public class Test01 {
	public static void main(String[] args) {

		// Scanner, Random, ArrayList,... => JAVA에서 기본적으로 제공하는 클래스 
		// Jsoup => JAVA에서 기본제공 하지 않는 클래스 -> 추가작업 해야함

		// 1. 웹 페이지 코드를 JAVA로 가져오기 (URL이 먼저 필요함)
		final String url = "https://www.melon.com/";
		// a) 해당 url의 페이지 코드를 받아오기위해, 연결통로(스트림)를 open
		// 		- connect()를 해야 한다
		Connection conn = Jsoup.connect(url); //import		
		// b) connect()가 정상적으로 수행되었다면, get()(getter)을 통하여
		// 	  해당 페이지의 코드를 받아옴
		Document doc =null;
		try {
			doc = conn.get(); //import, try-catch
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		//		System.out.println(doc); //스코프이슈

		// 2. 페이지 코드를 분석
				System.out.println(doc);

		// 3. 페이지 코드를 분석
		//  a) DOM 문서를 분석
		//     <></> 태그(요소, element) 단위로 분석
		//     속성 (property)을 가질수있으며, 
		// 		분석할때에 가장 대표적으로 활용되는 속성이
		// 		id(유일한 요소), class(여러개의 공통점을 가진 요소들)
		Elements elems = doc.select("a.ellipsis"); //elements는 여러개의 element를 갖고있음
		// 태그명#id명
		// 태그명.class명
		// 상위태그명 > 하위태그명
		//  => 파싱 (을 통해 데려온 상태)


		// 4. 분석하여 파싱완료한 데이터를 console 화면에 출력 
		// Iterator 이터레이터
		//  : 거대한 컬렉션(elems)에 있는 데이터를 작은 단위의 컬렌셕으로 나눠저장할수있도록 해주는 컬렉션
		Iterator<Element> itr=elems.iterator();
		// itr는 hasNext(),next()
		// 		다음 요소가 있어?, 그럼 다음거보여줘~ (==내꺼, <제네릭>에 해당하는 자료형) 보여줘
		while(itr.hasNext()) {
			String str = itr.next().toString();

			// 5. 데이터를 가공
			int index = str.indexOf(">"); //자를 위치
			str = str.substring(index+1); // 앞 자름
			index=str.indexOf("<"); //뒤 자를 위치
			str = str.substring(0, index);
			System.out.println(str);

		}







	}
}
