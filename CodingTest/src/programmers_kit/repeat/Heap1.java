<<<<<<< HEAD
package programmers_kit.repeat;

import java.util.PriorityQueue;

/**
 * 힙을 사용하려면 오름차순으로 정렬해서 낮은 순서대로 트리를 타야함 
 * PriorityQueue 를 사용하면 자동 정렬
 * queue 를 계속 poll 하면서 진행할 예정이므로 여기에서도 BFS DFS 와 같은 재귀가 필요 없음 
 * queue 에 size 가 1 이하여서 2개의 숫자를 뽑을 수 없는 경우도 생각을 해줘야함 
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
