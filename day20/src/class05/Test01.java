package class05;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Test01 {
	public static void main(String[] args) {
		final String url = "https://pages.coupang.com/f/s22381?from=home_C2&traid=home_C2&trcid=11251446";
		
		Connection conn=Jsoup.connect(url);
	
		Document doc=null;
		
		// 2. 페이지 스크랩핑 완료
		try {
			Elements elems = doc.select("strong.recommend-widget__item__title");
			doc=conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(doc);
		
	
	
	
	
	}
}
