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
                // 현재 인덱스가 가장 마지막에 와있다면
                minCost = Math.min(minCost, now.cost);
            }
            for (int i = 0; i < 4; i++) {
                // 4 방향으로 이동시킴
                int nextRow = now.row + d[i][0];
                int nextColumn = now.column +d[i][1];

                if(nextRow <0 || nextColumn <0 || nextRow>=num || nextColumn>=num || board[nextRow][nextColumn]==1){
                    // 이동한 값에 갈 수 없음
                    // 방향을 틀거나, 혹은 직진
                    continue;
                }
                // *** 이 부분이 메인
                // 만약 앞에 continue를 하지 않았다면 계속 직진해서 방향이 같을 것
                // 그러나 continue를 했다면 방향이 달라짐
                int nextCost = now.cost;
                if(now.direction == -1 || now.direction == i){
                    // direction이 처음 나오는 경우나 direction이 바뀌지 않음
                    nextCost += 100; // 직진
                }else{
                    nextCost += 600; // 코너
                }
                // 앞으로 더 어떻게 가야할까?
                // 매 행렬마다 거기까지 도달할 때의 값을 넣어주고, 최소를 비교
                if(!visited[nextRow][nextColumn][i] || board[nextRow][nextColumn] >= nextCost){
                    // 방문을 하지 않았거나
                    // 방문을 했더라도 현재까지 축적된 cost의 값이 더 작거나
                    // 더 크더라도 방문을 하지 않았거나
                    queue.add(new Node(nextRow, nextColumn, i, nextCost ));
                    visited[nextRow][nextColumn][i] = true;
                    // 방문
                    board[nextRow][nextColumn] = nextCost;
                    // 해당 matrix 까지 가는 비용을 저장함
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


