package algorithmTest;

import java.util.Scanner;

public class Section1_10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String t = in.next();
		int[] nstr = new int[str.length()];
		int p =1000;

		for (int i = 0; i < str.length(); i++) {
			String st = String.valueOf(str.charAt(i));
			if (st.equals(t)) {
				p=0;
				nstr[i] = p;
				
			} else {
				p++;
				nstr[i]=p;  
			}
			// 0 �� ������ �� �������� 1�� ������ 
		}
		p=1000;
		// �ʱ�ȭ 
		for (int i = str.length()-1; i >=0; i--) {
			String st = String.valueOf(str.charAt(i));
			if (st.equals(t)) {
				p=0;
				nstr[i] = p;
				
			}else {
				p++;
				nstr[i]=Math.min(nstr[i], p);
				// �ڿ������� �ٽ� �ݺ�, ������ �־��� ���� ���ؼ� ���� ���� ���� 
			}
			
		}
		
		
		for(int x : nstr) {
			System.out.print(x+" ");
		}
		return;
	}

}
