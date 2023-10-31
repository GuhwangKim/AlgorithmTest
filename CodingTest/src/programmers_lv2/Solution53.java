package CodingTest.src.programmers_lv2;

public class Solution53 {
	public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int leftmin = a[0];
        // 왼쪽 가장 끝의 값
        int rightmin = a[a.length-1];
        // 오른쪽 가장 끝의 값

        for (int i = 1; i <= a.length-1; i++) {
			if(leftmin>a[i]) {
				leftmin = a[i];
                // 왼쪽에 계속해서 최소 값을 저장함
			}
            leftMin[i] = leftmin;
		}

        for (int i = a.length-2; i > 0; i--) {
			// 오른쪽 가장 끝에서 앞에서부터 하나씩 내려옴
            if(rightmin>a[i]){
                rightmin = a[i];
            }
        	rightMin[i] = rightmin;
        	// 작은 걸로 그 앞에 인덱스가 됨

		}
        if(a.length == 1) { // 원소의 개수가 1개일 때
            return 1;
        }

        int answer = 2;
        for (int i = 1; i <= a.length-2 ; i++) {
            if(a[i]>leftMin[i] && a[i]>rightMin[i]){
                continue;  // 더커서 없어지기 때문
            }
            answer++;
        }
        return answer;
    }
}
