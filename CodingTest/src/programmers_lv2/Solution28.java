package programmers_lv2;

import java.util.*;

public class Solution28 {
	public static void main(String[] args) {
		Solution28 s = new Solution28();
		int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
		s.solution(6, arr);
		
	}
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

        for(int num : list){
            if(k>map.get(num)){
                k-=map.get(num);
                answer++;
            }else{
                answer++;
                return answer;
            }
        }
        return answer;
    }
}
