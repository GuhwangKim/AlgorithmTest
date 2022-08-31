package testTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String a = "100";
		String b = "200";
		
		int a2=Integer.parseInt(a);
		int b2=Integer.parseInt(b);
		
		System.out.println(a2*b2);
////////////////////////////////////////////////////////////////////////////////
		
		int basic=1500000;
		int time=55000;
		double tax=basic*0.1;
		double total=basic+time-tax;
		
		
		System.out.println("실수령액 : "+(int)total+"원");
		
////////////////////////////////////////////////////////////////////////////////
		
		String name="이효리";
		String dep="개발부";
		String pos="대리";
		int sal=15000000;
		
		System.out.println(name);
		System.out.printf(dep);
		System.out.println(pos+"\n"+sal+"\n");

////////////////////////////////////////////////////////////////////////////////
		
		int base=10;
		int height=3;
		
		double area=(base*height)/2;
		System.out.printf("%.2f",area);
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int q;
		int p;
		
		System.out.printf("a를 입력하시오 : "); q=Integer.parseInt(br.readLine());
		System.out.printf("b를 입력하시오 : "); p=Integer.parseInt(br.readLine());
		
		int max=q>p?q:p;
		
		System.out.println("큰 수 : "+max);

////////////////////////////////////////////////////////////////////////////////
		
		
		
	}

}
