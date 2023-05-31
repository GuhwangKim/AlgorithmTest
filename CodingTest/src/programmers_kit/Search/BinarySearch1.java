package programmers_kit.Search;

import java.util.Arrays;

public class BinarySearch1 {
	public long solution(int n, int[] times) {
        long answer = 0;
        
        // 1. times�� �ִ� ���ڸ� ���� <- �̺�Ž���� ������ �Ǿ�߸��� 
        Arrays.sort(times);
        // 2. times �� �ּҰ��� �ִ밪�� ���� <- ��� ���ڸ� ���ϱ� ����
        long maxTime = times[times.length-1]*(long)n;
        long minTime = 0;
        
        // 3. minTime >= maxTime �� �ɶ����� ����ؼ� �߰������� ������ ���̱� 
        while(minTime<=maxTime) {
        	long sumPeople = 0;
        	// 4. �߰����� ���� 
        	long mid = (maxTime+minTime)/2;
        	// 5. times �迭�� �ִ� �� ���� mid �� ���� ��, �� ó���� �� �ִ� �ο��� ���� ���� 
        	for(long value : times) {
        		sumPeople+=(mid/value);
        	}
        	// 6. �� ó���� �� �ִ� �ο��� ���� �־��� n ���� ū ��� 
        	// = mid ���̸� �̹� ��ó�� �� ������ => mid ���� �� ���� �� ���� 
        	if(sumPeople>=n) {
        		answer = mid;
        		// = ������ ������ ���� �� ���� 
        		maxTime = mid-1;
        	} else {
        		// 7. �ο��� �� ó������ �� ��
        		// = mid ���� �� �÷����� 
        		minTime = mid+1;
        	}
        }
        
        return answer;
    }

}
