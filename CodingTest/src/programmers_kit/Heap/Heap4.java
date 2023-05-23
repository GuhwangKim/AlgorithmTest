package CodingTest.src.programmers_kit.Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Heap4 {

        /*
            1. plays 에 있는 재생 횟수의 값을 genre의 분류별로 더해주는 작업
            2. genres 에 있는 값을 map의 key 값으로 넣고
            3. 저장할 때 그때의 i 값을 잃지 않는 것이 중요해
            3. value 값으로 총 횟수를 저장
        */

    public int[] solution (String[] genres, int[] plays){
        int[] answer = {};
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < genres.length; i++) {
            //value 값에 여러개의 값 즉 배열을 넣는 방법? i를 기억하기 위하여
            list.add(i);
            map.put(genres[i],list);


        }
        return answer;
    }

}
