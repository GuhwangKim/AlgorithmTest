package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Array2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndx = 0;
        int answer = 0;
        /**
         * 이렇게 일일이 다 검증할 필요 없음
         * 자기보다 큰 값은 전체 길이에서 그 해당 값의 인덱스 를 빼면 됨
         * 문제 이해를 제대로 못 함 
         * hidex citations.length-i; 를 구한 후 -> hidex 를 기준으로 다시 citations에 배열에서 이보다 더 큰 것을 찾음 
         * */
        for (int i = 0; i < citations.length; i++) {
        	hIndx = citations.length-i;
        	// 해당 논문 기준으로 그 이상 인용된 논문의 수 
        	if(citations[i] >= hIndx) {
        		// hIndx 번 이상 인용된 눈문을 다시 citations에서 찾음 
        		answer = Math.max(answer, hIndx);
        	}
		}
        
        
//        for (int i = 0; i < citations.length; i++) {
//            int cnt = 0;
//            for (int j = i; j < citations.length; j++) {
//                if(citations[i]<=citations[j]){
//                    cnt++;
//                }
//            }
//            if(cnt>=citations[i]){
//                hIndx = citations[i];
//                answer = Math.max(answer, hIndx);
//            }
//        }

        return answer;
    }
}
