package CodingTest.src.programmers_kit.DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsBfs7 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];

        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(table[i][j] == 1 && !visitedTable[i][j]){
                    // �湮���� �ʾҴµ�, ����� �ִ� ��� = �����¿쿡 ���ؼ� �ش��ϴ� ��ǥ list�� ��ȯ
                    BFS(i, j, visitedTable, table, 1, tableList);

                }
                if(game_board[i][j] == 0 && !visitedBoard[i][j]){
                    // �湮���� �ʾҴµ�, �� ������ ���
                    BFS(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }

        answer = findBlock(boardList, tableList);
        return answer;
    }

    private int findBlock(List<List<int[]>> board, List<List<int[]>> table) {
        int size = 0;

        int tableLen = table.size();
        int boardLen = board.size();

        boolean[] visitedBoard = new boolean[boardLen];
        for (int i = 0; i < tableLen; i++) {
            List<int[]> tablePoints = table.get(i); //�����¿� �̵������� �ش� �ϴ� ���� ��� ����Ʈ
            for (int j = 0; j < boardLen; j++) {
                List<int[]> boardPoints = board.get(i);

                if(tablePoints.size() == boardPoints.size() && !visitedBoard[j]){
                    // ���̺�� ���忡 �����¿� �̵��ÿ� ������ �´´ٸ�
                    if(isRoate(boardPoints, tablePoints)){
                        // ȸ���ؼ� �´��� Ȯ��

                    }
                }
            }
        }

        return 0;
    }

    private boolean isRoate(List<int[]> board, List<int[]> table) {
        boolean isCollect = false;
        board.sort(((o1, o2) -> {
            return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
        }));

        // ȸ��
        for (int i = 0; i < 4; i++) {
            table.sort(((o1, o2) -> {
                return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
            }));
        }

        int nearZeroX = table.get(0)[0];
        int nearZeroY = table.get(0)[1];

        for (int j = 0; j < table.size(); j++){
            table.get(j)[0] -= nearZeroX;
            table.get(j)[1] -= nearZeroY;
        }


        boolean isCollectPoint = true;
        for (int j = 0; j < board.size(); j++){ //��ǥ ��
            int[] boardPoint = board.get(j);
            int[] tablePoint = table.get(j);

            if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]){
                isCollectPoint = false;
                break;
            }
        }

        if (isCollectPoint){
            isCollect = true;
            break;
        } else{ //90�� ȸ�� : x,y -> y, -x
            for(int j = 0; j < table.size(); j++){
                int temp = table.get(j)[0];
                table.get(j)[0] = table.get(j)[1];
                table.get(j)[1] = -temp;
            }
        }
        return isCollect;
    }



    private void BFS(int currentX, int currentY, boolean[][] visited, int[][] graph, int blockOrEmpty, List<List<int[]>> list) {
        Queue<int[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        // �湮������ ǥ����

        queue.add(new int[]{currentX, currentY});
        //queue�� ��ǥ�� �������

        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] pop = queue.remove();
            int popX = pop[0];
            int popY = pop[1];

            for (int i = 0; i < 4; i++) {
                // �迭 �ϳ��ϳ� �̵��ϸ鼭 Ž����
                int nextX = popX + dx[i];
                int nextY = popY + dy[i];

                if(nextX<0 || nextX>= graph.length || nextY<0 || nextY>= graph.length){
                    // ���� ������ �Ѿ ��� �Ѿ
                    continue;
                }
                if(!visited[nextX][nextY] && graph[nextX][nextY]==blockOrEmpty){
                    // �湮���� ���� ��ǥ�̰�, gameboard = ��ĭ / table = ��� �̶��
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                    subList.add(new int[]{nextX-currentX,nextY-currentY}); // �̺κ� ��?
                }

            }

        }
        list.add(subList);

    }
}
