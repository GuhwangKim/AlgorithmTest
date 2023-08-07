package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution28 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        Map<Integer,Integer> map = new HashMap<>();

        for(int tan : tangerine){
            if(map.containsKey(tan)){
                map.put(tan, map.get(tan)+1);
            }else{
                map.put(tan, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.values());


        return answer;
    }
}
