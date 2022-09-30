package programmers_lv2;

public class Solution5 {
	class Solution {
		// 2개의 메소드가 함께 쓸 것이기 때문에 전역 변수로 선언 
		private boolean[] visit;
		int answer = -1;

		public int solution(int k, int[][] dungeons) {
			// 순서 크기 만큼 존재 
			visit= new boolean[dungeons.length];
			
			dfs(0,k,dungeons);
			// 0 부터 시작 
			
			return answer;
		}

		public void dfs(int depth, int k, int[][] dungeons) {
			for (int i = 0; i < dungeons.length; i++) {
				if(!visit[i]&&dungeons[i][0]<=k) {
					visit[i]=true;//방문처리 시작 모듈 0 , 1, 2 ...
					dfs(depth+1, k-dungeons[i][1], dungeons); // 
					visit[i]=false; // i+1 부터 시작하는 로직 반복될때 전 것은 방문하지 않은 상태로 만들어줘야함
				}
			}
			// dfs(depth+1, k-dungeons[i][1], dungeons) 여기서 dept 값이 하나씩 증가함 
			// 시작 처리 모듈이 달라질 때 마다 answer에 depth가 저장이 되고 -> 새로운 depth와 비교
			// = 즉 최대 값
			answer=Math.max(answer, depth);
		}
	
	
	}

}
