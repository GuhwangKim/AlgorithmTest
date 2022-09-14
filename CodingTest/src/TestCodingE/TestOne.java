package TestCodingE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestOne {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int ip=Integer.parseInt(input);
		
		for (int i = 0; i < ip; i++) {
			for (int j = 1; j < ip-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2*i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
