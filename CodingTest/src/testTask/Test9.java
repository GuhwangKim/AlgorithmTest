package testTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.printf("Input Character: "); String cha=br.readLine();
		
		char cha1=cha.charAt(0);
		
		if(cha1>='a'&&cha1<='z') {
			System.out.printf(cha.toUpperCase());
		}else if (cha1>='A'&&cha1<='Z') {
			System.out.println(cha1);
		}else {
			System.out.println("입력데이터오류");
		}
		
	}
	
	
}
