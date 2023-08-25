package programmers_kit.repeat;

public class Search5 {
	static int count = 0;
	static boolean finalEnd = false;
	char[] aeiou = { 'A', 'E', 'I', 'O', 'U' };
	
	public int solution(String word) {
        DFS("", word, 0);
        return count;
    }

	private void DFS(String cbnAlphabet, String givenWord, int depth) {
		// TODO Auto-generated method stub
		if(depth==6) {
			// 끝 
			return;
		}
		
		if(givenWord.equals(cbnAlphabet)) {
			finalEnd = true;
			// 정답 
			return;
		}
		
		for (int i = 0; i < aeiou.length; i++) {
			if(finalEnd) {
				return;
				// 정답인 경우 끝 
			}
			if(depth<5) {
				count++;
				//0부터 새기 시작함 4자리수까지 
				DFS(cbnAlphabet+aeiou[i], givenWord, depth+1);
			}
			
		}
		
	}
}
