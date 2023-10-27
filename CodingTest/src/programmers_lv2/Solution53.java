package CodingTest.src.programmers_lv2;

public class Solution53 {
	public int solution(int[] a) {
        if(a.length == 1) {
        	return 1;
        }
        
        int leftMin = a[0];
        // 왼쪽 가장 끝의 값 
        int[] rightMin = new int[a.length];
        rightMin[a.length-1] = a[a.length-1];
        // 오른쪽 가장 끝의 값
        
        for (int i = a.length-2; i > 0; i--) {
			// 오른쪽 가장 끝에서 앞에서부터 하나씩 내려옴 
        	rightMin[i] = Math.min(rightMin[i+1], a[i]);//***
        	// 작은 걸로 그 앞에 인덱스가 됨 
        	
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
