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
            // n/2+1 �� ���� ��ŭ�� queue �� �� ������� ���� �־�ΰ� ����
            for (int j = 1; j <= (n/times.length)+1; j++) {
                list.add(times[i]*j);
            }
        }
        // ����
        list.sort((a1, a2)->a1-a2);
        // n��°
        totalTimes = list.get(n-1);

        /*Map<Integer, Queue<Integer>> map = new HashMap<>();

        if(n==0){
            // ���� ��ٸ��� ����� ���ٸ� ��ȯ
            return totalTimes;
        }

        for (int i = 0; i < times.length; i++) {
            // n/2+1 �� ���� ��ŭ�� queue �� �� ������� ���� �־�ΰ� ����
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
            // map �� ��� �ִ� ������ ���ڵ��� ���ϰ� ���� ���� �͵��� �̾Ƴ�
            // n �� �پ��� �ϰ� n �� 0�̶�� ��ž
            int preNum = timesValues.get(i).peek();
            int nextNum = timesValues.get(i+1).peek();
            if(preNum<nextNum){
                totalTimes+=preNum;
                // ���� �� �� ��� ����
                timesValues.get(i).poll();
                DFS(timesValues, people-1);
            }else{

            }
        }


    }*/
}
