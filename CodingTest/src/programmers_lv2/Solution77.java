package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution77 {
    public int solution(int[] A, int[] B) {
        // A와 B를 정렬함
        Arrays.sort(A);
        Arrays.sort(B);

        int idx = 0;

        for (int i = 0; i < B.length; i++) {
            if(A[idx]>=B[i]){
                // A의 값이 더 크면 = B가 지는 것이기 때문에 넘어감
                // B는 넘어가지만 A는 움직이지 않음
                continue;
            } else{
                // B가 더 큼 => A도 함께 넘어감
                idx++;
            }
        }
        return idx; // 정답은 A의 몇번째까지 대결을 했는지
    }
}
