package TestCodingE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTwo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int[] val=new int[3];
		String[] str=input.split(" ");
		
		for (int i = 0; i < val.length; i++) {
			val[i]=Integer.parseInt(str[i]);
		}
		System.out.println(val[0]);
		System.out.println(val[1]);
		System.out.println(val[2]);
		
		int max=0;
		int min=0;
		
		if(val[0]>=val[1]) {
			max=val[0];
			min=val[1];
		} else {
			max=val[1];
			min=val[0];
		}
		
		int two=val[2];
		
		if(val[2]>0) {
			for (int i = 1; i <= val[2]; i++) {
				if(max!=min) {
					min++;
					two--;
				} else {
					break;
				}
			}
			if(two>0) {
				min=min+(two/2);
				max=min+(two/2);
				System.out.println(min*2);
				
			}else {
				System.out.println(min*2);
			}
		
			
		} else {
			System.out.println(min*2);
		}
		
	}

}
