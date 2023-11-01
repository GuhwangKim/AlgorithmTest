package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution55 {
    int[][] d = {{-1, 0}, {1,0}, {0,1}, {0, -1}};
    boolean[][][] visited;
    int num;
    public int solution(int[][] board) {
        num = board.length;
        visited = new boolean[num][num][4];

        return BFS(board);
    }

    private int BFS(int[][] board) {
        int x = 0, y=0, direction = -1, cost=0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, direction, cost));

        int minCost= Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.row == num-1 && now.column == num-1){
                // ���� �ε����� ���� �������� ���ִٸ�
                minCost = Math.min(minCost, now.cost);
            }
            for (int i = 0; i < 4; i++) {
                // 4 �������� �̵���Ŵ
                int nextRow = now.row + d[i][0];
                int nextColumn = now.column +d[i][1];

                if(nextRow <0 || nextColumn <0 || nextRow>=num || nextColumn>=num || board[nextRow][nextColumn]==1){
                    // �̵��� ���� �� �� ����
                    // ������ Ʋ�ų�, Ȥ�� ����
                    continue;
                }
                // *** �� �κ��� ����
                // ���� �տ� continue�� ���� �ʾҴٸ� ��� �����ؼ� ������ ���� ��
                // �׷��� continue�� �ߴٸ� ������ �޶���
                int nextCost = now.cost;
                if(now.direction == -1 || now.direction == i){
                    // direction�� ó�� ������ ��쳪 direction�� �ٲ��� ����
                    nextCost += 100; // ����
                }else{
                    nextCost += 600; // �ڳ�
                }
                // ������ �� ��� �����ұ�?
                // �� ��ĸ��� �ű���� ������ ���� ���� �־��ְ�, �ּҸ� ��
                if(!visited[nextRow][nextColumn][i] || board[nextRow][nextColumn] >= nextCost){
                    // �湮�� ���� �ʾҰų�
                    // �湮�� �ߴ��� ������� ������ cost�� ���� �� �۰ų�
                    // �� ũ���� �湮�� ���� �ʾҰų�
                    queue.add(new Node(nextRow, nextColumn, i, nextCost ));
                    visited[nextRow][nextColumn][i] = true;
                    // �湮
                    board[nextRow][nextColumn] = nextCost;
                    // �ش� matrix ���� ���� ����� ������
                }
            }
        }
        return minCost;

    }

    private class Node {
        int row, column, direction, cost;

        public Node(int row, int column, int direction, int cost){
            this.row = row;
            this.column = column;
            this.direction = direction;
            this.cost = cost;
        }

    }

}


