package CodingTest.src.programmers_kit.repeat;

public class DfsBfs3 {
    int[] dx ={-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean visited[][];
    int answer = 0;
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        /**
         * 0 0 �� ����
         * ��ǥ�� ��ġ�� ����
         * ���� ��ġ�� ���ٸ� �׶� level�� ��ȯ�ϰ�, math����
         * idx map.length -1, maps[0].length -1 ���� ���� ����� ���� ����
         * */

        DFS(0, 0, maps, 0);

        return 0;
    }

    private void DFS(int positionX, int positionY, int[][] maps, int cnt) {
        if(positionX== maps.length && positionY==maps[0].length){
            // ��ǥ�� ������ ���� ���� ��
            answer = Math.min(cnt, answer);
            return;
        }



    }
}
