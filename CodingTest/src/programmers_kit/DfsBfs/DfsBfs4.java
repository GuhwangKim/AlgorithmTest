package programmers_kit.DfsBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DfsBfs4 {

	static boolean[] visited;
	static int cntFly =0;
	static List<String> visitedAllRoutes = new ArrayList<String>();
	public String[] solution(String[][] tickets) {
		// 1. �湮Ȯ�� ���� �迭 ����
		visited = new boolean[tickets.length];
		String[] answer = new String[tickets.length];
		
		
		// 2. ICN ���� �����Ϸ��� ICN �� �ѱ� 
		DFS(tickets, "ICN", "ICN", 0 );
		// 8. �������� ��Ʈ���� ���� �ٵ� �� ��Ʈ�� ���ĸ� �� ���� = "����" ����
		Collections.sort(visitedAllRoutes);
		
		// 9. ���� �Ŀ� ���� ù��° ����Ʈ ��, ���ĸ� ���� ���� ���� ���� �̾Ƽ� , �������� split 
		answer = visitedAllRoutes.get(0).split(",");

		return answer;
	}

	private void DFS(String[][] tickets, String backFly, String routes, int cntFly) {
		// 6. ���� ���� �������� �� = ��� �װ����� �� ������ �� stop 
		if(cntFly==tickets.length) {
			// 7. ������ ���������� �׋��� �� �ش� ��Ʈ�� ����Ʈ�� ��
			visitedAllRoutes.add(routes);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			// 3. �Ѿ�� �װ���� ����� �װ����� �ְ� = 2���� �迭 0 ���� ���� ���� 
			// 4. �湮���� �ʾҴٸ� = 2���� �迭���� false �� ����
			if(backFly.equals(tickets[i][0]) && !visited[i]) {
				visited[i]=true;
				// 5. ��Ʈ�� �ϳ��� �߰��� "����" ��, ������ �迭�� ���ڸ� �Բ� �ѱ� 
				DFS(tickets, tickets[i][1], routes+","+tickets[i][1], cntFly+1);
				visited[i]=false;
			}
			// �������� ���� �ִ� ��� ���ĺ��� ����?? 
		}
		
	}
}
