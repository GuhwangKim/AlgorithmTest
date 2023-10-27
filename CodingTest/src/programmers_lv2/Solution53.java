package CodingTest.src.programmers_lv2;

public class Solution53 {
	public int solution(int[] a) {
        if(a.length == 1) {
        	return 1;
        }
        
        int leftMin = a[0];
        // ���� ���� ���� �� 
        int[] rightMin = new int[a.length];
        rightMin[a.length-1] = a[a.length-1];
        // ������ ���� ���� ��
        
        for (int i = a.length-2; i > 0; i--) {
			// ������ ���� ������ �տ������� �ϳ��� ������ 
        	rightMin[i] = Math.min(rightMin[i+1], a[i]);//***
        	// ���� �ɷ� �� �տ� �ε����� �� 
        	
		}
        int answer = 2;
        for (int i = 0; i < a.length; i++) {
			if(!(leftMin < a[i] && rightMin[i] < a[i])) {
				answer++;
			}
			leftMin = Math.min(leftMin, a[i]); //***
		}
        
        return answer;
    }
}
