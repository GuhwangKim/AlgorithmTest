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

        int startTime = 9*60; // 처음 버스 출발 시간
        int lastTime = 0;
        int total = 0;

        for (int i = 0; i < n; i++) { // 버스
            total = 0;
            while (!queue.isEmpty()){ // 기다리는 사람 수
                int currentTime = queue.peek();
                if(currentTime <= startTime && total < m){
                    // 시작 시간 보다 일찍왔고, 아직 태울 수 있다면
                    queue.poll();
                    total++; // 총 태울 인원
                }else
                    break;

                lastTime = currentTime-1; // 마지막 태운 사람 보다 1초 먼저 와야함
            }
            startTime+=t; // 간격을 더함, 그 다음 버스의 시작 시간
        }
        if(total<m){ // 모든 사람 다 태움
            lastTime = startTime-t;
        }


        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        return hour + ":" + minute;
    }
}
