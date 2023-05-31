package programmers_kit.Search;

import java.util.Arrays;

public class BinarySearch1 {
	public long solution(int n, int[] times) {
        long answer = 0;
        
        // 1. times에 있는 숫자를 정렬 <- 이분탐색은 정렬이 되어야만함 
        Arrays.sort(times);
        // 2. times 의 최소값과 최대값을 구함 <- 가운데 숫자를 구하기 위함
        long maxTime = times[times.length-1]*(long)n;
        long minTime = 0;
        
        // 3. minTime >= maxTime 이 될때까지 계속해서 중간값으로 범위를 줄이기 
        while(minTime<=maxTime) {
        	long sumPeople = 0;
        	// 4. 중간값을 구함 
        	long mid = (maxTime+minTime)/2;
        	// 5. times 배열에 있는 각 값을 mid 로 나눈 값, 즉 처리할 수 있는 인원의 수를 더함 
        	for(long value : times) {
        		sumPeople+=(mid/value);
        	}
        	// 6. 총 처리할 수 있는 인원의 수가 주어진 n 보다 큰 경우 
        	// = mid 값이면 이미 일처리 다 끝났음 => mid 값을 더 줄일 수 있음 
        	if(sumPeople>=n) {
        		answer = mid;
        		// = 오른쪽 값들을 전부 다 버림 
        		maxTime = mid-1;
        	} else {
        		// 7. 인원을 다 처리하지 못 함
        		// = mid 값을 더 늘려야함 
        		minTime = mid+1;
        	}
        }
        
        return answer;
    }

}
