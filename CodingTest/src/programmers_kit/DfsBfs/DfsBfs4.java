package programmers_kit.DfsBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DfsBfs4 {

	static boolean[] visited;
	static int cntFly =0;
	static List<String> visitedAllRoutes = new ArrayList<String>();
	public String[] solution(String[][] tickets) {
		// 1. 방문확인 목적 배열 생성
		visited = new boolean[tickets.length];
		String[] answer = new String[tickets.length];
		
		
		// 2. ICN 부터 시작하려면 ICN 을 넘김 
		DFS(tickets, "ICN", "ICN", 0 );
		// 8. 여러가지 루트들이 있을 텐데 그 루트별 알파멧 순 정렬 = "문장" 정렬
		Collections.sort(visitedAllRoutes);
		
		// 9. 정렬 후에 가장 첫번째 리스트 즉, 알파멧 순가 가장 빠른 값을 뽑아서 , 기준으로 split 
		answer = visitedAllRoutes.get(0).split(",");

		return answer;
	}

	private void DFS(String[][] tickets, String backFly, String routes, int cntFly) {
		// 6. 가장 깊이 내려왔을 때 = 모든 항공편을 다 돌았을 떄 stop 
		if(cntFly==tickets.length) {
			// 7. 끝까지 내려왔으면 그떄의 총 해당 루트를 리스트에 삽
			visitedAllRoutes.add(routes);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			// 3. 넘어온 항공편과 연결된 항공편이 있고 = 2차원 배열 0 번쨰 값과 같음 
			// 4. 방문하지 않았다면 = 2차원 배열에서 false 인 상태
			if(backFly.equals(tickets[i][0]) && !visited[i]) {
				visited[i]=true;
				// 5. 루트를 하나씩 추가한 "문장" 과, 제거한 배열의 숫자를 함께 넘김 
				DFS(tickets, tickets[i][1], routes+","+tickets[i][1], cntFly+1);
				visited[i]=false;
			}
			// 여러개의 답이 있는 경우 알파벳순 정렬?? 
		}
		
	}
}
