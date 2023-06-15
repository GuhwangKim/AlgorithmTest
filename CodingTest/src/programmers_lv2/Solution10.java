package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution10 {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        String[] startNum =new String[plans.length];

        for (int i = 0; i < plans.length; i++) {
            startNum[i]=plans[i][1];
        }
        String[][] startNum2 = new String[2][plans.length];
        for (int i = 0; i < plans.length; i++) {
            String[] splitString = startNum[i].split(":");
            startNum2[0][i]=splitString[0];
            startNum2[1][i]=splitString[1];
        }

        Arrays.stream(plans).filter(strings -> )



        return answer;
    }
}
