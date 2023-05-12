package programmers_kit.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap2 {

	public int solution(int[][] jobs) {
		// ���� ������ ���� ���� 
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		// jobs �� �ܿ� �ð��� ���� ����
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int cnt = 0;    // �Ϸ�� �۾��� ����
        int total = 0; // �հ� �ð�
        int endTime = 0; // ª�� ������� ������ �迭���� �۾��� �Ϸ�� �ð�
        int idx = 0; // 0 1 ~ 
        
        
        while (cnt < jobs.length) {
			while (idx < jobs.length && jobs[idx][0]<=endTime) {
				// 1. �� ���μ����� ������ ���� ���� �͵鿡 ���ؼ� 
				queue.add(jobs[idx++]);
				// 2. �� ����־��� - jobs ���� �ະ�� �����ؼ� ������� - 0 1 �� ���� ���� 
			}
			
			if(queue.isEmpty()) {
				endTime = jobs[idx][0];
				// 3. ���μ����� ������ ���� �Ŀ� ����Ǵ� ���μ����� ���� �ÿ� ���� �۾��� �Ϸ�ð��� 
				// ���۽ð����� ���� 
				
			} else { 
				int[] cur = queue.poll();
				total += cur[1]+endTime-cur[0];
				// 4. ����ð� + ������ �Ϸ� ���� - ���� ���� (������ ������ ���) 
				endTime += cur[1];
				// 5. �ٽ� �Ϸ� ������ �۾� ����Ⱓ
				cnt ++; 
			}
		}
        return total / jobs.length;
	}

}
