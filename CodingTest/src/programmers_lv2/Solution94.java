package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution94 {
    public String solution(String s) {
        String answer = "";

        int[] splitedNum = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(splitedNum);

        answer = String.valueOf(splitedNum[0]) + " " +String.valueOf(splitedNum[splitedNum.length]);
        return answer;
    }
}
