package model;

import java.util.ArrayList;

// CRUD(����Ͻ� �޼���,�ٽ� ����)
public class StudentDAO {

	private ArrayList<StudentVO> datas;
	private static int PK=1001;
	/*
	PK�� ����ڷκ��� �Է¹����� �ȵ�!!!!!
	ID�� �Է¹�������������, "�ߺ��˻�"�� ��!
	�ý��ۿ��� int���� �ο��ؾ���!!!!!
	 */
	public StudentDAO(){
		this.datas=new ArrayList<StudentVO>();
		this.datas.add(new StudentVO(PK++,"ȫ�浿",85));
		this.datas.add(new StudentVO(PK++,"�ƹ���",92));
		this.datas.add(new StudentVO(PK++,"Ƽ��",51));
	}

	// C
	public void insert(String name,int score) {
		this.datas.add(new StudentVO(PK++,name,score));
	}

	// R : ��� ���
	public ArrayList<StudentVO> selectAll() {
		return this.datas;
	}
	// R : 1�� ���
	public StudentVO selectOne(int num) { // PK�� �޾Ƽ�,
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				return this.datas.get(i);
			}
		} // -> ���� for��(forEach��)
		System.out.println("  �α�: model: StudentDAO: selectOne(): ��ȯ�� �л��� �����ϴ�!");
		return null; // �ش� PK�� ���� �л��� ���� ����
	}

	// U
	public void update(int num,int score) {
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.get(i).setScore(score);
				return;
			}
		}
		System.out.println("  �α�: model: StudentDAO: update(): ���������� �л��� �����ϴ�!");
	}

	// D
	public void delete(int num) {
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.remove(i);
				return;
			}
		}
		System.out.println("  �α�: model: StudentDAO: delete(): ������ �л��� �����ϴ�!");
	}










}
