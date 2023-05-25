package model;

import java.util.ArrayList;

// CRUD(비즈니스 메서드,핵심 로직)
public class StudentDAO {

	private ArrayList<StudentVO> datas;
	private static int PK=1001;
	/*
	PK는 사용자로부터 입력받으면 안됨!!!!!
	ID를 입력받을수는있으나, "중복검사"를 함!
	시스템에서 int값을 부여해야함!!!!!
	 */
	public StudentDAO(){
		this.datas=new ArrayList<StudentVO>();
		this.datas.add(new StudentVO(PK++,"홍길동",85));
		this.datas.add(new StudentVO(PK++,"아무무",92));
		this.datas.add(new StudentVO(PK++,"티모",51));
	}

	// C
	public void insert(String name,int score) {
		this.datas.add(new StudentVO(PK++,name,score));
	}

	// R : 목록 출력
	public ArrayList<StudentVO> selectAll() {
		return this.datas;
	}
	// R : 1개 출력
	public StudentVO selectOne(int num) { // PK를 받아서,
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				return this.datas.get(i);
			}
		} // -> 향상된 for문(forEach문)
		System.out.println("  로그: model: StudentDAO: selectOne(): 반환할 학생이 없습니다!");
		return null; // 해당 PK를 가진 학생이 없는 상태
	}

	// U
	public void update(int num,int score) {
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.get(i).setScore(score);
				return;
			}
		}
		System.out.println("  로그: model: StudentDAO: update(): 성적변경할 학생이 없습니다!");
	}

	// D
	public void delete(int num) {
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.remove(i);
				return;
			}
		}
		System.out.println("  로그: model: StudentDAO: delete(): 제거할 학생이 없습니다!");
	}










}
