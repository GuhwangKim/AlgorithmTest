package algorithmTest;

import java.util.ArrayList;
import java.util.Scanner;


public class Section8_14 {
	static int n, m, len;
	static int answer = Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> pz, hs;
	
	static class Point{
		public int x, y; // 좌효 
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private void DFS(int L, int s) {
		if(L==m) {
			// 피자 집 개수가 도닳했을 때  
			int sum = 0;
			for(Point h : hs) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) {
					// 조합의 인덱스 번호 
					dis = Math.min(dis,  Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
				}
				sum+=dis;
				// 도시의 피자배달 거리 
			}
			answer = Math.min(answer, sum);
		}else {
			for (int i = s; i < len; i++) {
				// 인덱스 번호 0 ~ 피자집개수까지 
				combi[L]=i;
				// 개수는 총 4개 뿐
				DFS(L+1, i+1);
				// 피자집들이 모든 조합으로 개수 만큼 뽑힘 
				
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
					// 집인 경우의 좌표 값을 저장한 인스턴스를 배열에 저장 
				} else if (tmp==2) {
					pz.add(new Point(i, j));
					// 피자가게 경우의 좌표 값을 저장한 인스턴스를 배열에 저장 
				}
			}
		}
		len = pz.size();
		combi = new int[m];
		T.DFS(0,0);
		System.out.println(answer);
	}

}
