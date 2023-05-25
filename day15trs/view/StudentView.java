package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.StudentVO;

// MVC�߿��� V�� ����ϴ� Ŭ������,
// main()�� ���۽�Ű�°��� ��ǥ���ƴ�!
public class StudentView {

	private static final int maxMenuNum=6;
	// ���� �������� ���� �ڵ带 �����ϱ�����!
	private static Scanner sc=new Scanner(System.in);
	
	// �޴��� �ȳ����ִ� ���
	// 1. �л�������
	// 2. �л��˻�
	// 3. �л���������
	public void printMenu() {
		System.out.println("===�л��� ���α׷�===");
		System.out.println("1. ������");
		System.out.println("2. �л��˻�");
		System.out.println("3. ��������");
		System.out.println("4. �л��߰�");
		System.out.println("5. �л�����");
		System.out.println("6. ���α׷� ����");
	}

	// ������� �Է��� �����ϴ� ���
	//  + ��ȿ�� �˻�
	public int getMenuNum() {
		while(true) {
			try {
				System.out.print("�Է�) ");
				int menuNum=sc.nextInt();

				if(1<=menuNum && menuNum<=maxMenuNum) {
					return menuNum;
				}
			}
			catch(Exception e) {
				sc.nextLine();
				System.out.println("������ �Է����ּ���!");
			}			
		}		
	}

	// �л������ ����ϴ� ���
	public void printStudentList(ArrayList<StudentVO> datas) {
		System.out.println("===�л� ��� ���===");
		for(StudentVO v:datas) {
			System.out.println(v);
		}
	}

	// �˻��� �л��� ������ ����ϴ� ���
	public void printStudent(StudentVO data) {
		System.out.println("===�л� ���===");
		System.out.println(data);
	}

	// ����ڰ� �Է��� ��ȣ�� �����ϴ� ���
	public int getStudentNum() {
		System.out.print("�л���ȣ�Է�) ");
		int num=sc.nextInt();
		return num;
	}

	// ����ڰ� �Է��� ������ �����ϴ� ���
	public int getStudentScore() {
		System.out.print("�л������Է�) ");
		int score=sc.nextInt();
		return score;
	}

	// ����ϷḦ �ȳ����ִ� ���
	public void printInfo() {
		System.out.println("�л���������Ϸ�!");
	}
	
	// �л��߰��� �ȳ���Ʈ
	public void printInfo_C_Start() {
		System.out.println("�л��߰��� �����մϴ�.");
	}
	
	// �̸� �Է¹ޱ�
	public String getStudentName() {
		System.out.print("�̸��Է�) ");
		String name=sc.next();
		return name;
	}
	
	// �л��߰��ϷḦ �ȳ����ִ� ���
	public void printInfo_C_End() {
		System.out.println("�л��߰��Ϸ�!");
	}
	
	// �л������� �ȳ���Ʈ
	public void printInfo_D_Start() {
		System.out.println("�л������� �����մϴ�.");
	}
	
	// �л������ϷḦ �ȳ����ִ� ���
	public void printInfo_D_End() {
		System.out.println("�л������Ϸ�!");
	}
	
	// ���α׷� ���� �ȳ����ִ� ���
	public void printEnd() {
		System.out.println("���α׷� ���� .....");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
