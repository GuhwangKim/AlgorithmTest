package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Binary1 {
    public long solution(int n, int[] times) {
    /**
     * 1. 최대 최소 값의 중간 값을 구함
     * 2. 중간값/소요시간 = 처리가능한 사람의 수 ***
     * 3. *** 최대 = 최소 값이 같을 때까지 최소 최대 값을 줄이고 더하는 작업을 반복
     * */
        Arrays.sort(times);
        long totalTime = 0;

        long maxTime = times[times.length-1]*n;
        long minTime = 0;
        // 기준의 값을 구하는 방법이란 = 1사람당 걸리는 시간으로 구함

        while(minTime<=maxTime){
            int sumPeople = 0;
            long mid = (maxTime+minTime)/2; // 30
            for (int i = 0; i < times.length; i++) {
                sumPeople+=mid/times[i]; // 중간 값 / 소요시간  = 처리할 수 있는 사람의 수
            }

            if(sumPeople>=n){
                // 시간을 줄여도 됨
                totalTime = mid;
                maxTime = mid-1;

            } else{
                // 시간이 모자름 시간을 늘려야함
                minTime = mid+1;
            }
        }
        return totalTime;
    }
}
