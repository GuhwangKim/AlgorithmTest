package algorithmTest;

import java.util.ArrayList;
import java.util.Scanner;


public class Section8_14 {
	static int n, m, len;
	static int answer = Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> pz, hs;
	
	static class Point{
		public int x, y; // ��ȿ 
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private void DFS(int L, int s) {
		if(L==m) {
			// ���� �� ������ �������� ��  
			int sum = 0;
			for(Point h : hs) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) {
					// ������ �ε��� ��ȣ 
					dis = Math.min(dis,  Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
				}
				sum+=dis;
				// ������ ���ڹ�� �Ÿ� 
			}
			answer = Math.min(answer, sum);
		}else {
			for (int i = s; i < len; i++) {
				// �ε��� ��ȣ 0 ~ �������������� 
				combi[L]=i;
				// ������ �� 4�� ��
				DFS(L+1, i+1);
				// ���������� ��� �������� ���� ��ŭ ���� 
				
			}
		}
		
	}

	public static void main(String[] args) {
		Section8_14 T = new Section8_14();
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		pz = new ArrayList<>();
		hs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = in.nextInt();
				if(tmp==1) {
					hs.add(new Point(i, j));
					// ���� ����� ��ǥ ���� ������ �ν��Ͻ��� �迭�� ���� 
				} else if (tmp==2) {
					pz.add(new Point(i, j));
					// ���ڰ��� ����� ��ǥ ���� ������ �ν��Ͻ��� �迭�� ���� 
				}
			}
		}
		len = pz.size();
		combi = new int[m];
		T.DFS(0,0);
		System.out.println(answer);
	}

}
