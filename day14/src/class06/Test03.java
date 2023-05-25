package class06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// "사진 복사하기"
public class Test03 {
	public static void main(String[] args) {
		
		final String path = "D:\\JINLEE\\resource\\";
		final String fileName = "test.png";
		final String fileCopy = "test-복사본.png";
		
		try {
			FileInputStream fis = new FileInputStream(path+fileName);//"기존 사진 파일"
			FileOutputStream fos = new FileOutputStream(path+fileCopy);//"복사본 생성"
			
			int data; 
			byte[] buff = new byte[10000]; //버퍼공간; 사진데이터를 이만큼 읽어와서 무언가 작업하고... 
			//사진이랑 사용할땐 .read 2번째꺼 (3번째꺼는 더 큰 워드파일 같은거)
			while( (data=fis.read(buff)) != -1) {
				//System.out.println("확인");
				//작성할때에는 .write 3번째꺼
				fos.write(buff, 0, data);
			}
			//★★★★★
			fos.flush();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("사진 실습 완료");
		}
		
		
		
		
		
	}
}
