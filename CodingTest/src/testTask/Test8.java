package testTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int grade;
		
		System.out.printf("������ �Է��Ͻÿ� : "); grade=Integer.parseInt(br.readLine());
	
		if(grade<0||grade>100) {
			System.out.println("�Է¿���!!");
		}else {
			System.out.println("�Էµ� ��: "+grade);
		}

	}

}
