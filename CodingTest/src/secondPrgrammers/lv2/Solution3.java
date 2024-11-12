package CodingTest.src.secondPrgrammers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ĳ��
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * */
public class Solution3 {
    public int solution(int[] picks, String[] minerals) {
        // ������ ������θ� 
        // pick �� ������� �����ϴ� ��� 1��° -> 2��° ���� -> 3��° 
        // 1 2 3 , 1 3 2 , 2 1 3, 2 3 1, 3 1 2 , 3 2 1 �� 6���� ������ (0����)
        // �ش� ��쿡 ���� minerals�� ��ȸ�ϸ鼭 ���� ���ϰ� max�� �� (minerals�� ������) 

        // pick ���� ���ڰ� �Ѱ���
        int answer = Integer.MAX_VALUE;
        String[] tools = new String[3];

        // ����� ���� ���� �迭 (�� 6��)


        // ���� �Ƿε�
        int currentTired = 0;

        for (int i = 0; i < picks.length; i++) {
            // bfs (3������ ���� �� check function level,
            bfs(0, i, tools);

        }

        answer = Math.min(answer, currentTired);

        return answer;
    }

    private void bfs(int level, int index, String[] tools) {
        if (level > 3) {
            // ���� �ܰ���� ��
            return;
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        // ù���� �ε����� �����

        while (queue.isEmpty()) {
            String currentPicksPower = "";
            int currentIdx = queue.poll();

            if (index == 0) {
                currentPicksPower = "diamond";
            } else if (index == 1) {
                currentPicksPower = "iron";
            } else{
                currentPicksPower = "stone";
            }
            tools[level] = currentPicksPower;
        }
    }

    private int check (int currentPick, String currentPicksPower) {
        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];
            while (currentPick > 0) {
                if (currentPicksPower.equals("diamond")) {
                    currentTired++; // 1�� �߰�

                } else if (currentPicksPower.equals("iron")) {
                    if (mineral.equals("diamond")) {
                        currentTired += 5;
                    }else{
                        currentTired++;
                    }
                }else{
                    if (mineral.equals("diamond")) {
                        currentTired += 25;
                    } else if (mineral.equals("iron")) {
                        currentTired += 5;
                    }else{
                        currentTired++;
                    }
                }
            }
            currentPick--;
        }
    }
    
}
