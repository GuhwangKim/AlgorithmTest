package programmers_lv2;

public class Solution71 {
	public String solution(int n, int t, int m, int p) {
        // ���ڸ� �����غ��� 1~ n�������� ��ȯ�ؼ� ������ 
        // (p����+m�ο��� * t-1) ������ ���ϸ� �� 
        
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; convert.length() <= t*m; i++) {
			// ������ ���� + ������ �ο� ��ŭ ���� = ���ؾ��ϴ� ���� 
        	convert.append(Integer.toString(i, n));
		}
        
        for (int i = p-1; answer.length() < t; i+=m) {
			// �ε����̱� ������ p ���� -1 , t���� ���� �� 
        	answer.append(convert.charAt(i));
		}
        
        return answer.toString().toUpperCase();
    }

}
