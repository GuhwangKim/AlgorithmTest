package work3;

import java.util.List;

public class StudentView {
	public void viewStudent(Student st) {
		System.out.println(st.getName()+st.getAge()+st.getHeight()+st.getWeight());
	}
	
	public void viewStudentList(List<Student> list) {
		for (Student student : list) {
			System.out.println(student.getName()+student.getAge()+student.getHeight()+student.getWeight());
		}
	}
}
