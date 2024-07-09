package CodingTest.src.programmers_lv2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution91Test {

    @Test
    void 테스트해보자 () {
        Solution91 solution91 = new Solution91();
        int answer = solution91.solution(3);
        assertEquals(2, answer);
    }

}