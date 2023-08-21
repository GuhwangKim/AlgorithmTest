package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution34 {
    public int solution(int[] elements) {
        int[] attached = new int[elements.length*2];

        for (int i = 0; i < attached.length; i++) {
            attached[i] = attached[i+ elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < attached.length; j++) {
                set.add(Arrays.stream(attached, j, j+i).sum());

            }
        }

        return set.size();
    }
}
