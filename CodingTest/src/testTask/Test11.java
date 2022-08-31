package testTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test11 {
	public static void main(String[] args) throws IOException {
		
		double a= Double.parseDouble(args[0]);
		double b= Double.parseDouble(args[1]);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String x;
		
		System.out.println("연산자를 입력(+,-,*,/) : "); x=br.readLine();
		
		if(x.equals("+")) {
			System.out.printf((int)a+x+(int)b+"="+(int)(a+b));
		}
		else if(x.equals("-")) {
			System.out.printf((int)a+x+(int)b+"="+(int)(a-b));
		}
		else if(x.equals("*")) {
			System.out.printf((int)a+x+(int)b+"="+(int)(a*b));
		}
		else if (x.equals("/")) {
			System.out.println((int)a+x+(int)b+"=");
			System.out.printf("%.2f",a/b);
		}
		else {
			System.out.println("연산자 error");
		}
		
	}
}
