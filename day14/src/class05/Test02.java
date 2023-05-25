package class05;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
[문제 2]
"D:\\JINLEE\\resource\\test02.txt"파일이 있습니다.
아무내용도 작성되어있지 않습니다.
abcde...xyz까지 작성해주세요!~~
 */

public class Test02 {
	public static void main(String[] args) {
		File file = new File("D:\\JINLEE\\resource\\test02.txt");
		//파일 생성하기
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("파일객체생성 완료!");
		}
		//3. 파일 작성하기
		try {
			FileOutputStream fos = new FileOutputStream("D:\\JINLEE\\resource\\test02.txt",true); 
			int a='a';
			int z='z';
			for(int i=a; i<=z;i++) {
				fos.write(i); 
			}

//			for(int i=a; i<=z; i++) {
//				if(i)
//			}
			
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("fos객체로 파일 작성하기 작업 완료!");
		}
		
		//2. 읽어오기

		try {
			FileInputStream fis=new FileInputStream("D:\\JINLEE\\resource\\test02.txt");  
			int data; 
			while( (data=fis.read()) != -1) { 
				System.out.print((char)data); 
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			System.out.println("fis 파일 읽어오기 작업 완료 ");
		}


	}
}
