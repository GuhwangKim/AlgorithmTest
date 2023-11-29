package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution67 {
    static ArrayList<Integer>[]list;
    static boolean visited[];   // �����׷����̴� ť���� ���� �ݺ��� �����ϱ� ����
    static Queue<Integer> queue = new LinkedList<>();
    static int arr[];

    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        arr = new int[n+1];

        // �� ��� �� ���� ����� ���(Integer)���� ��� List�� ������
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int front = edge[i][0];
            int back = edge[i][1];
            list[front].add(back);
            list[back].add(front);
            // ����� �հ� �ڿ� ������ ���� ���� (�������)
        }

        queue.add(1);
        // 1���� ������
        visited[1] = true;
        // 1�� ����ħ

        while (!queue.isEmpty()){
            int nodeVal = queue.poll();
            for (int child : list[nodeVal]){
                // �ش��ϴ� ��� ���� ����� ������
                if(visited[child]){
                    continue; // �̹� �湮�ߴٸ� �ƿ�
                }
                queue.add(child);
                // �湮 �������� queue�� �߰���
                visited[child] = true;
                // �湮ǥ��
                arr[child] = arr[nodeVal]+1;
                // �ش� ��带 �ε����� ���� ���� �θ��� ����� ������ �����ؼ� ������ **
            }
        }

        Arrays.sort(arr);
        // �׷��� �ؼ� ���� �迭�� ������
        int cnt = 0;
        int max = arr[n];
        for (int i = n; i >= 1; i--) {
            // �Ųٷ� ������ (���� ū �ͺ���)
            if(max == arr[i]){
                // ���� ū ���� ���� ���� ������
                cnt++;
            }else{
                break;
            }
        }
        
        return cnt;
    }

    private int DFS(int cntcNum, int[][] edge, int distance, boolean[] visited) {
        visited[cntcNum] = true;
        // �湮��
        for (int[] each : edge){
            if(each[0] == cntcNum || !visited[each[1]]){
                // ����� ���� �湮���� �ʾҴٸ�
                distance++; // ����Ǿ����� 1�� �߰� ��
                DFS(each[1], edge, distance, visited);
                visited[each[1]] = false; // Ǯ���� 
            }
        }

        return distance;
    }
}
