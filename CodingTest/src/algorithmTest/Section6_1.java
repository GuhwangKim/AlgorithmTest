package algorithmTest;

import java.util.Scanner;

public class Section6_1 {

	private int[] T(int a, int b, int[] arr) {
		int[] cahce = new int[a];
		for(int x : arr) {
			int pos = -1; 
			// ���� ���� �̹� �迭�� �ֳ� �� 
			for (int i = 0; i < a; i++) {
				if(x==cahce[i]) {
					pos = i; 
				}
			}
			
			// ó�� ���� ���� �� 
			if(pos==-1) {
				for (int i = a-1; i >=1; i--) {
					cahce[i]=cahce[i-1];
					// ��ĭ�� �и� 
				}
				cahce[0]=x; // ���� �տ��� ���� ���� �� 
			}else {
				//�̹� ���� ���� �� �� ���� �������� ��ĭ �и� 
				for (int i = pos; i >=1; i--) {
					cahce[i]=cahce[i-1];
					// ��ĭ�� �̵� 
				}
				cahce[0]=x; // ���� �տ��� ���� ���� ��
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
