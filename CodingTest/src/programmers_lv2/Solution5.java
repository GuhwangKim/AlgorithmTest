package programmers_lv2;

public class Solution5 {
	class Solution {
		// 2���� �޼ҵ尡 �Բ� �� ���̱� ������ ���� ������ ���� 
		private boolean[] visit;
		int answer = -1;

		public int solution(int k, int[][] dungeons) {
			// ���� ũ�� ��ŭ ���� 
			visit= new boolean[dungeons.length];
			
			dfs(0,k,dungeons);
			// 0 ���� ���� 
			
			return answer;
		}

		public void dfs(int depth, int k, int[][] dungeons) {
			for (int i = 0; i < dungeons.length; i++) {
				if(!visit[i]&&dungeons[i][0]<=k) {
					visit[i]=true;//�湮ó�� ���� ��� 0 , 1, 2 ...
					dfs(depth+1, k-dungeons[i][1], dungeons); // 
					visit[i]=false; // i+1 ���� �����ϴ� ���� �ݺ��ɶ� �� ���� �湮���� ���� ���·� ����������
				}
			}
			// dfs(depth+1, k-dungeons[i][1], dungeons) ���⼭ dept ���� �ϳ��� ������ 
			// ���� ó�� ����� �޶��� �� ���� answer�� depth�� ������ �ǰ� -> ���ο� depth�� ��
			// = �� �ִ� ��
			answer=Math.max(answer, depth);
		}
	
	
	}

}
