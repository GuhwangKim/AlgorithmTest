package CodingTest.src.programmers_lv2;

public class Solution16 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    public int solution(String[] maps) {
        int count = 0;
        visited = new boolean[maps.length][maps.length];
        count = BFS(maps, 0, 0, 0);


        return count;
    }

    private int BFS(String[] maps, int startRow, int startColumn, int level) {
        char presentChar = maps[startRow].charAt(startColumn);
        int answer = level;
        // �Ѱܿ� ��� ���� ���� exit �̰ų� ���� �϶� ����
        if(presentChar =='E' || presentChar == 'L' ){
            answer = Math.min(answer, level);
        }
        // ��ǥ �����̱�
        for (int i = 0; i < 4; i++) {
            int nextRow = startRow + dx[i];
            int nextColumn = startColumn + dy[i];

            // ��ȿ���� ���� �� �Ѿ
            if(nextRow>= maps.length || nextRow<0 || nextColumn>=maps.length || nextColumn<0){
                continue;
            } else{
                BFS(maps, nextRow, nextColumn, level+1);
            }


        }



        return answer;
    }
}
