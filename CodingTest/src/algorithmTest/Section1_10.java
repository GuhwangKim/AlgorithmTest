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
			// 0 이 나오면 그 다음부터 1씩 더해줌 
		}
		p=1000;
		// 초기화 
		for (int i = str.length()-1; i >=0; i--) {
			String st = String.valueOf(str.charAt(i));
			if (st.equals(t)) {
				p=0;
				nstr[i] = p;
				
			}else {
				p++;
				nstr[i]=Math.min(nstr[i], p);
				// 뒤에서부터 다시 반복, 기존에 있었던 값과 비교해서 작은 값이 대입 
			}
			
		}
		
		
		for(int x : nstr) {
			System.out.print(x+" ");
		}
		return;
	}

}
