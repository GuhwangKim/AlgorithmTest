<<<<<<< HEAD
package programmers_kit.repeat;

import java.util.PriorityQueue;

/**
 * ���� ����Ϸ��� ������������ �����ؼ� ���� ������� Ʈ���� Ÿ���� 
 * PriorityQueue �� ����ϸ� �ڵ� ����
 * queue �� ��� poll �ϸ鼭 ������ �����̹Ƿ� ���⿡���� BFS DFS �� ���� ��Ͱ� �ʿ� ���� 
 * queue �� size �� 1 ���Ͽ��� 2���� ���ڸ� ���� �� ���� ��쵵 ������ ������� 
 * 
 * */

public class Heap1 {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int num : scoville) {
			queue.add(num);
		}
		
		while(queue.peek()<K) {
			if(queue.size()==1) {
				return -1;
			}else {
				queue.add(queue.poll()+(queue.poll()*2));
				answer++;
			}
		}
		return answer;

	}



=======
package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap1 {
    public int solution(int[] scoville, int K) {
        int cnt =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.stream(scoville).forEach(queue::add);

        while(!queue.isEmpty()){
            if(queue.size()==1){
                if(queue.poll()==K){
                    return cnt;
                } else{
                    return -1;
                }
            }
            int kCandidate = queue.poll()+queue.poll();
            cnt++;
            if(kCandidate==K){
                return cnt;
            } else{
                queue.add(kCandidate);
            }
        }

        return -1;
    }
>>>>>>> refs/remotes/AlgorithmTest/master
}
