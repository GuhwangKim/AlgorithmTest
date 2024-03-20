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

        int startTime = 9*60; // 가장 빠른 시간
        int lastTime = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total = 0;
            while (!queue.isEmpty()){
                int currentTime = queue.peek();
                if(currentTime <= startTime && total < m){
                    queue.poll();
                    // 아직 태울 인원 더 있음
                    total++; // 총 태울 인원
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
