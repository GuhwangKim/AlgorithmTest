package algorithmTest;

import java.util.Scanner;

public class Section8_1 {
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false;
	int sum = 0;
	
	private void DFS(int L, int sum, int[] arr) {
		if(flag) return; 
		// �Ʒ� ����� �������� �ʰ�, ���ؿ� ���� �͵�� ���� ��� ���� 
		if(sum>total/2) return; 
		// �̹� ���� Ŀ������ �� ���� 
		if(L==n) { 
		//L�� 0���� ����, 6���� ���ٸ� (�κ����� �ϼ�)  
			if((total-sum)==sum) {
				answer ="YES";
				flag = true;
			}
		}else {
			// 2������ ����� 
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	
	
	public static void main(String[] args) {
		Section8_1 T = new Section8_1();
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
			total+=arr[i];
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}

}
