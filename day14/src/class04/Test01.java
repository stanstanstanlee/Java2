package class04;
// i.o : input output
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) {
		//파일입출력에서 제일 먼저 배워야 할 것 : 
		//1. 파일 생성하기
						//File에게는 기본생성자가 없으며 그렇다는것은 이미 오버로딩이 되어 있다는 뜻
		File file = new File("D:\\JINLEE\\resource\\test.txt");//경로를 작성 해 줘야행
		// 해당 파일이 존재하지 않으면, 새로 생성해줌! 이게 실제 OS에 존재해? 없으면 내가 만들어줄겡
		try {
		
			file.createNewFile();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		} finally { //됬는지 않됬는지 확인 할 수 있는 방법
			System.out.println("파일객체생성 완료!");
		}
		
		// 2. 파일 읽어오기
	
//		FileInputStream fis=new FileInputStream(file); //<<이것도 가능<<오버로딩 되어있졍 
		try {
			FileInputStream fis=new FileInputStream("D:\\JINLEE\\resource\\test.txt"); //<<얘 읽어올랭 //보통 얘로 씀 
			int data; // read()가 int로 읽어오니까 변수 필요 
			while( (data=fis.read()) != -1) { //txt파일 내용의 길이를 모름 // read() char로 읽어오는게 아니라 int로 읽어와용 
				// (=) 먼저  !=
				// 읽어온 데이터가 -1이면 "다 읽었다."는 의미
				System.out.print((char)data); //int로 가져오니까 형변환 타입캐스팅을 해 줘야 함 
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			System.out.println("fis 파일 읽어오기 작업 완료 ");
		}
		
		//3. 파일 작성하기
		try {
			FileOutputStream fos = new FileOutputStream("D:\\JINLEE\\resource\\test.txt",true); //생성자 오버로딩이 되어있엉
			//파일이 존재하지 않으면 새로 생성
			//★★★ 파일이 존재하면 "덮어쓰기" ★★★ 실무에서 유의 ★★★
			//파일이 존재할때, '이어쓰기' : ,true 
			
			fos.write(65); //'A'
			fos.write(97); //'a' -> 아스키 코드로 소통 함
			
			// ★★★★★ fos는 닫지않으면 에러가 발생 할 수 있음. 
			//OS와 소통하던 통로를 직접 닫아주지 않으면 다음 수행시 문제가 발생 할 수도 있다! 
			//소통시 열어진 통로를 직접 닫지 않으면 에러가 발생 할 수도 있음.
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(IOException e) {
			
			e.printStackTrace();
		} finally {
			System.out.println("fos객체로 파일 작성하기 작업 완료!");
		}
		
		//run 계속 하면 Aa 계속 추가됨 ㅎ
		
	}
}
