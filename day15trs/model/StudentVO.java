package model;

// �л� ������ �� ��ü�� �ǹ���
// �������+getter,setter
// toString() �������̵�
// ������(�����ε�)
public class StudentVO {
	private int num;
	private String name;
	private int score;
	StudentVO(int num,String name,int score){
		this.num=num;
		this.name=name;
		this.score=score;
		System.out.println(this.name+" �л� �����Ϸ�!");
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return this.num+"�� �л� "+this.name+" ["+this.score+"��]";
	}
}
