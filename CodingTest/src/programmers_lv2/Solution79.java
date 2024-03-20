package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution79 {

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(String table : timetable){
            int time  = Integer.parseInt(table.substring(0,2))*60 + Integer.parseInt(table.substring(3));
            queue.add(time);
        }

        int startTime = 9*60; // ���� ���� �ð�
        int lastTime = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total = 0;
            while (!queue.isEmpty()){
                int currentTime = queue.peek();
                if(currentTime <= startTime && total < m){
                    queue.poll();
                    // ���� �¿� �ο� �� ����
                    total++; // �� �¿� �ο�
                }else
                    break;

                lastTime = currentTime-1;
            }
            startTime+=t;
        }
        if(total<m){
            lastTime = startTime-t;
        }


        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        return hour + ":" + minute;
    }
}
