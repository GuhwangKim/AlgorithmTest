package algorithmTest;

import java.util.Scanner;

public class Section6_1 {

	private int[] T(int a, int b, int[] arr) {
		int[] cahce = new int[a];
		for(int x : arr) {
			int pos = -1; 
			// 나온 값이 이미 배열에 있나 비교 
			for (int i = 0; i < a; i++) {
				if(x==cahce[i]) {
					pos = i; 
				}
			}
			
			// 처음 나온 값일 때 
			if(pos==-1) {
				for (int i = a-1; i >=1; i--) {
					cahce[i]=cahce[i-1];
					// 한칸씩 밀림 
				}
				cahce[0]=x; // 가장 앞에는 현재 나온 수 
			}else {
				//이미 나온 값일 떄 그 값을 기준으로 한칸 밀림 
				for (int i = pos; i >=1; i--) {
					cahce[i]=cahce[i-1];
					// 한칸씩 이동 
				}
				cahce[0]=x; // 가장 앞에는 현재 나온 수
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Section6_1 section = new Section6_1();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr = new int[a];
		int b = in.nextInt();
		in.nextLine();
		String str2 = in.nextLine();
		String[] sarr = str2.split(" ");
		for (int i = 0; i < sarr.length; i++) {
			arr[i]=Integer.parseInt(sarr[i]);
		}
		for(int x : section.T(a,b, arr)) {
			System.out.print(x+" ");
		}
	}
}
