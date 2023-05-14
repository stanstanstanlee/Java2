package class02;
/*

학생  6명
29 99 30 22 87 57
1    3  4   
평균점수
평균을 넘긴 학생수
6등의 번호
짝수번째 학생들의 총점 
평균을 못넘긴 학생들의 번호 

 */
public class Task01 {
	public static void main(String[] args) {

//		int[] stu = new int[6];
		
		int[] stu = {29, 99, 30, 22, 87, 57};
		
		int sum = 0;
		double avg = 0;
		int abvAvg = 0;
	
		
		for(int i=0;i<stu.length;i++) {
			sum = sum + stu[i];
			if(stu[i] > 54) {
				abvAvg++;
			}

		}
		avg = (sum*1.0) / stu.length;
//		System.out.println(sum);
		System.out.println("평균 점수는 " + avg + "점 입니다.");
		System.out.println("평균 점수를 넘긴 학생의 수는 " + abvAvg + "명 입니다.");

		
		
		// 6등 min
		int min=stu[0]; // 현재 최저값이 [0]에 존재하는 값이다!
		int minIndex=0; // 최저값이 저장된 index를 기억할 변수 // 최저값이 저장된 공간을 기억하는 애 이기 때문에 최저값이 바뀔때만 바뀌면 됨
		
		
		// [1] 부터 차례대로 '현재 최저값'과 비교
		for(int i=1;i<stu.length;i++) {
			if(min>stu[i]) { //최처값이 현재비교값보다 크다면,
				// 변화 발생!
				min=stu[i];
				minIndex=i;
			}
		}
		System.out.println("6등을 한 학생의 번호는 " + (minIndex+1) + "번 입니다");
		
		//짝수번째 학생들의 총점
		
		int sumEvn = 0;
		
		for(int i=0;i<stu.length;i++) {
			if((i+1)%2==0) {
//				System.out.println(stu[i]);
				sumEvn += stu[i];
			}
		}
		System.out.println("짝수번째 학생들의 총점은 "+sumEvn + "점 입니다");
		
		int blwAvg = 0;
		
		for(int i=0;i<stu.length;i++) {
			if(stu[i] < avg) {
				blwAvg++;
			}
		}
		System.out.println(blwAvg);
		int[] blwAvgNo = new int[blwAvg];
		
		int j=0;
		for(int i =0;i<stu.length;i++) {
			if(stu[i]<avg) {
//				System.out.println("평균을 못넘긴 학생들의 번호는 " + (i+1)+ "번 입니다");
				blwAvgNo[j++] = (i+1);
			}
		}
		
		System.out.print("평균을 못넘긴 학생들의 번호는 ");
		for(int i =0; i<blwAvgNo.length;i++) {
			System.out.print( blwAvgNo[i]+" ");
		}
		System.out.print("번 입니다");
	}
}
   