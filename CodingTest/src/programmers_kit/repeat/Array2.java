package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Array2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndx = 0;
        int answer = 0;
        // 앞의 값은 너무 작아서 최대 값이 아님
        // 자기 보다 큰 값이 자기 개수보다 많아야 함
        // 뒤에 값은 너무 커서 참고하는 논문이 없음


        /**
         * 이렇게 일일이 다 검증할 필요 없음
         * 자기보다 큰 값은 전체 길이에서 그 해당 값의 인덱스 를 빼면 됨
         * */
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
