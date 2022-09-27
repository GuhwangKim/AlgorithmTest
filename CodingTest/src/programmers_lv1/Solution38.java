package programmers_lv1;

public class Solution38 {
	class Solution {
		public int solution(int n) {
			int answer = 0;
			int[] number=new int[n+1];
			
	        // 2 �̻� �ڿ��� �̱� ������ 
			for (int i = 2; i <=n; i++) {
				number[i]=i;
				
			}
			
			// 2 ���� �����ؼ� 2���� ������ �ڿ����� ���� ����� (1�� ���� �� �ڱ� �ڽ�)
			// 0 ���� ����
			for (int i = 2; i <=n; i++) {
				for (int j = 2*i; j <=n; j+=i) {
					// 2 : 4 6 8 ---
					// 3 : 6 9 12 ---
					// 4 : 8 12 16 
					number[j]=0;
				}
			}
			
			for (int i = 2; i < number.length; i++) {
				if(number[i]!=0)
					answer++;
			}
			
			return answer;
		}
	}

}
