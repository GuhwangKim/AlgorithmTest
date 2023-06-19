package CodingTest.src.programmers_kit.repeat;

import java.util.HashSet;
import java.util.Set;

/**
 * 가장 위 노드 LOOP
 * 갔던 것은 다시 안가는 DFS 이므로 
 * DFS LOOP 안에서 인덱스 값만 또 넘김 
 * */

public class Search1 {
    boolean[] visited;
    Set<Integer> answerSet = new HashSet<>();
    String number;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        number = numbers;
        
        for (int i = 0; i < numbers.length(); i++) {
        	visited[i]=true;
            DFS(0, String.valueOf(numbers.charAt(i)));
            visited[i]=false;
        }
        
        return answerSet.size();
    }

   

    private void DFS(int idx, String idxNum) {
    	
    	if(idx>visited.length) {
    		return;
    	}
    	
    	if(isPrime(Integer.parseInt(idxNum))) {
    		answerSet.add(Integer.parseInt(idxNum));
    	}
    	
    	
    	for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				DFS(i, idxNum+String.valueOf(number.charAt(i)));
				visited[i]=false;
			}
		}
	}



	public static boolean isPrime(int num) {
        if(num==1||num==0) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
