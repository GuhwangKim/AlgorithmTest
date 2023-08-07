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

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(int num : map.values()){
            if(k>num){
                System.out.println("num : "+num);
                System.out.println("k : "+k);

                k-=num;
                answer++;
            }else{
                System.out.println("num : "+num);
                System.out.println("k : "+k);
                answer++;
                return answer;
            }
        }
        return answer;
    }
}
