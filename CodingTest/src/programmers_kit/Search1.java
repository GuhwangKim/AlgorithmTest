package programmers_kit;

import java.util.HashSet;

public class Search1 {
	static char[] chs; 
	static HashSet<Integer> set = new HashSet<Integer>();
	static String numbsersUse;
	public int solution(String numbers) {
		int answer = 0;
		numbsersUse = numbers;
		boolean[] visited = new boolean[numbers.length()];
		for (int i = 1; i < numbers.length(); i++) {
			perm_dfs(0, i, "", visited);
			// 깊이, 자리수 (3자리 수이라면 1~2), 붙여지는 수, 중복체크 
		}
		answer = set.size();
		return answer;
	}
	
	// 1. 소수를 확인하는 메소드 
	public static boolean isPrime(int num) {
		for (int i = 2; i * i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 2. 순열
	public void perm_dfs(int depth, int len, String number, boolean visit[]) {
		if(depth == len){
			// 깊이와 자리수가 같다면 
            int num=Integer.valueOf(number);
            if(isPrime(num)){
                set.add(num);
            }
            return;
        }
		
        for(int i=0; i<numbsersUse.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                // 자리수 - 방문했다면 표시 
                perm_dfs(depth+1, len, number+numbsersUse.charAt(i), visit);
                visit[i] = false;
                // 풀어줌 
            }
        }
		
		
		
	}

	

	
}
