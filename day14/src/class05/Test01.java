package class05;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
[문제 1]
"D:\\JINLEE\\resource\\test01.txt"파일이 있습니다.
정수가 1개 작성되어있습니다.

	ex) 2 => 12
	 
입력되어있는 정수는 짝(홀)수입니다. 
 */
public class Test01 {
	
	public static void main(String[] args) {
		File file = new File("D:\\JINLEE\\resource\\test01.txt");
		//파일 생성하기
		try {
			
			file.createNewFile();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		} finally {
			System.out.println("파일객체생성 완료!");
		}
		//읽어오기
		try {
			FileInputStream fis=new FileInputStream("D:\\JINLEE\\resource\\test01.txt");  
			int data; 
			while( (data=fis.read()) != -1) { 
				if(data%2==0) {
					System.out.print("짝 ");
				} else System.out.print("홀 ");
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("fis 파일 읽어오기 작업 완료 ");
		}
		
		int num = 'a';
		System.out.println(num);
	}
}
