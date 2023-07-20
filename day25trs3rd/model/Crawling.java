package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 멤버변수없이 메서드만 존재하는 클래스
//  : 메서드 실행이 목적
public class Crawling {
	
	public static ArrayList<MovieVO> sample() {
		final String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		Connection conn = Jsoup.connect(url);
		Document doc = null;
		try {
			doc = conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements elems = doc.select("strong.title");
		Elements elems2 = doc.select("span.txt-info");

		Iterator<Element> itr = elems.iterator();
		Iterator<Element> itr2 = elems2.iterator();

		//////////////////////////////
		ArrayList<MovieVO> mdatas=new ArrayList<MovieVO>();
		//////////////////////////////
		
		while(itr.hasNext()) {
			String str = itr.next().toString();
			String str2 = itr2.next().toString();

			int index = str.indexOf(">");
			str = str.substring(index+1);
			index = str.indexOf("<");
			str = str.substring(0, index);

			int index2 = str2.indexOf("<strong>");
			str2 = str2.substring(index2+9);
			index2 = str2.indexOf("<span>");
			str2 = str2.substring(0, index2);

			/*
			System.out.println(str);
			System.out.println(str2);
			System.out.println();
			 */
			
			mdatas.add(new MovieVO(0,str,str2));
		}
		
		return mdatas;
	}
}
