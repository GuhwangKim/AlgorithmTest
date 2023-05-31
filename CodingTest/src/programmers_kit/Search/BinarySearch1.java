package CodingTest.src.programmers_kit.Search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinarySearch1 {
    static  long totalTimes = 0;
    public long solution(int n, int[] times) {

        LinkedList<Integer>list = new LinkedList<>();

        for (int i = 0; i < times.length; i++) {
            // n/2+1 의 길이 만큼만 queue 에 그 배수들을 집어 넣어두고 싶음
            for (int j = 1; j <= (n/times.length)+1; j++) {
                list.add(times[i]*j);
            }
        }
        // 정렬
        list.sort((a1, a2)->a1-a2);
        // n번째
        totalTimes = list.get(n-1);

        /*Map<Integer, Queue<Integer>> map = new HashMap<>();

        if(n==0){
            // 현재 기다리는 사람이 없다면 반환
            return totalTimes;
        }

        for (int i = 0; i < times.length; i++) {
            // n/2+1 의 길이 만큼만 queue 에 그 배수들을 집어 넣어두고 싶음
            for (int j = 1; j <= (n/times.length)+1; j++) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(times[i]*j);
                map.put(i,queue);
            }
        }

        DFS(map, n);*/


        return totalTimes;
    }

/*    private void DFS(Map<Integer, Queue<Integer>> timesValues, int people) {
        if(people==0){
            return;
        }

        for (int i = 0; i <= timesValues.size(); i++) {
            // map 에 담겨 있는 각각의 숫자들을 비교하고 가장 적은 것들을 뽑아냄
            // n 을 줄어들게 하고 n 이 0이라면 스탑
            int preNum = timesValues.get(i).peek();
            int nextNum = timesValues.get(i+1).peek();
            if(preNum<nextNum){
                totalTimes+=preNum;
                // 제거 함 한 사람 끝남
                timesValues.get(i).poll();
                DFS(timesValues, people-1);
            }else{

            }
        }


    }*/
}
