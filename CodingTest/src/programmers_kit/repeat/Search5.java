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
			// �� 
			return;
		}
		
		if(givenWord.equals(cbnAlphabet)) {
			finalEnd = true;
			// ���� 
			return;
		}
		
		for (int i = 0; i < aeiou.length; i++) {
			if(finalEnd) {
				return;
				// ������ ��� �� 
			}
			if(depth<5) {
				count++;
				//0���� ���� ������ 4�ڸ������� 
				DFS(cbnAlphabet+aeiou[i], givenWord, depth+1);
			}
			
		}
		
	}
}
