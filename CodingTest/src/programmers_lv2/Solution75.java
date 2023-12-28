package CodingTest.src.programmers_lv2;

import java.util.LinkedList;

public class Solution75 {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length*5;
        }
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if(cache.remove(s)){
                // 해당 도시가 있고, 지운후 true를 반환함
                // hit 인 경우 실행시간 1
                answer += 1;
                cache.add(s);
            } else{
                // miss 인 경우 실행시간 5
                answer += 5;
                if(cache.size() >= cacheSize){
                    // 현재 저장하고 있는 캐시 사이즈 >= 주어진 캐시 사이즈
                    cache.remove(0);
                    // 가장 앞에 있는 값을 삭제
                }
                cache.add(s);
                // 그리고 신규를 집어 넣음

            }
        }
        return answer;
    }
}
