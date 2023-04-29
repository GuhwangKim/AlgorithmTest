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
			// ����, �ڸ��� (3�ڸ� ���̶�� 1~2), �ٿ����� ��, �ߺ�üũ 
		}
		answer = set.size();
		return answer;
	}
	
	// 1. �Ҽ��� Ȯ���ϴ� �޼ҵ� 
	public static boolean isPrime(int num) {
		for (int i = 2; i * i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 2. ����
	public void perm_dfs(int depth, int len, String number, boolean visit[]) {
		if(depth == len){
			// ���̿� �ڸ����� ���ٸ� 
            int num=Integer.valueOf(number);
            if(isPrime(num)){
                set.add(num);
            }
            return;
        }
		
        for(int i=0; i<numbsersUse.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                // �ڸ��� - �湮�ߴٸ� ǥ�� 
                perm_dfs(depth+1, len, number+numbsersUse.charAt(i), visit);
                visit[i] = false;
                // Ǯ���� 
            }
        }
		
		
		
	}

	

	
}
