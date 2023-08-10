package CodingTest.src.programmers_kit.repeat;

import java.util.LinkedList;
import java.util.Queue;

public class Search4 {
    static int arr[][];
    public int solution(int n, int[][] wires) {
        /**
         * wires�� ���̴� ���� ����
         * N�� ����� ����
         * */
        int answer = 0;

        arr = new int[n+1][n+1];

        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
            //�迭�� �� �� ���� �Ѵ� ǥ������,
        }

        for (int i = 0; i < wires.length; i++) {
            int frontNum = wires[i][0];
            int backNum = wires[i][1];

            arr[frontNum][backNum] = 0;
            arr[backNum][frontNum] = 0;
            // ���� ����

            answer = Math.min(answer, BFS(frontNum, n)); // ����� ��������, ����
            

            arr[frontNum][backNum] = 1;
            arr[backNum][frontNum] = 1;
            // ����

        }

        return answer;
    }

    private int BFS(int frontNum, int nodeCnt) {
        boolean[] visited = new boolean[nodeCnt+1];
        int cnt  = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(frontNum);
        // �ձ���
        
        while(!queue.isEmpty()) {
        	int queueFirstNode = queue.poll();
        	visited[queueFirstNode] = true;
        	// �湮�� �밢���� = �ڱ� �ڽ� ������ 0 
        	for (int i = 1; i <= nodeCnt; i++) {
				// ���� �������� 1�� �ֳ� Ž, 1�ΰ�� �̾��� �ִ� ����̱� ������ ���� ���� 
        		if(visited[i]) {
        			continue;
        		}
        		if(arr[queueFirstNode][i]==1) {
        			queue.offer(i);
        			cnt++;
        		}
			}
        	
        }
        
        return (int)Math.abs(nodeCnt - 2*cnt);

    }
}
