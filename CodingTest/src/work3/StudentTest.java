package work3;

import java.util.ArrayList;

public class StudentTest {

	public static void main(String[] args) {
		
		Student st1=new Student("�ε鷹", 15, 170, 55);
		Student st2=new Student("���޷�", 22, 165, 53);
		Student st3=new Student("������", 20, 155, 46);
		
		StudentView st=new StudentView();
		st.viewStudent(st1);
		
		ArrayList<Student> list=new ArrayList<Student>();
		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		
		st.viewStudentList(list);
		
	}
}
