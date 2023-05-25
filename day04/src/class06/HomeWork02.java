package class06;

import java.util.Random;
import java.util.Scanner;

public class HomeWork02 {
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		//배열에 랜덤수 저장
		for(int i=0; i<arr.length;i++) {
			arr[i] = rand.nextInt(101);
			for(int j=0; j<i;j++) {
				if(arr[i]==arr[j]) { //혹시 중복이야?
					i--;			// 그럼 돌아가
				}
			}
		}

		//출력으로 배열 확인
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
				
		//배열 정렬 오름차순
		int tmp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j] < arr[i]) { //arr[j]가 arr[i]보다 작다면
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		//출력으로 배열 확인
		System.out.println();
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//이진탐색
		//low, high, 중간 값
		int low = 0;
		int high = arr.length-1;
		int mid =0; 
		int key=35;// key: 찾는값; 
		int res = -1; //어느 인덱스에 있는지 찾았을때 인덱스로 위치를 알려줌
		//탐색이 언제 끝날지 모르니 while문으로 탐색
		while(low<=high) { //가장낮은 값이 가장 큰값보다 같거나 작을때
			mid = (low + high) / 2; //중간 인덱스를 찾아서 저장

			if(key==arr[mid]) { //찾는 값이 중간에 있는 값과 같다면 탐색 완료 (무한반복 종료값)
				res = mid;
				break; //탐색 성공 했으니 while문 종료
			}
			else if(key<arr[mid]) { //찾는 값이 중간에 있는 값보다 작다면
							// 중간값포함 오른쪽의 모든 값을 버려준다(우리가 찾는 key값보다 큰값들이니까)
				high = mid-1; // mid인덱스를 왼쪽으로 (-1) 한칸 옮겨서 새로운 high값을 설정 해 줌

			}
			else {//(key>arr[mid]) //찾는 값이 중간에 있는 값보다 크다면
							//중간값 포함 왼쪽의 모든 값이 우리가 찾는 key값보다 낮은 값들이라는 뜻이니
				low = mid+1; //mid인덱스를 오른쪽으로 (+1) 한칸 옮긴 값이 가장 낮은 값이라고 가정한다
			}
		}
		if(res>=0) {
			System.out.println(key+"값은 arr["+res+"]에 저장되어있습니다.");
		} else System.out.println(key+"값은 배열에 없습니다!");
	}

}
