package CodingTest.src.programmers_kit.repeat;

public class Search3 {
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
    /**
     * current >= i0
     *  -> - i1 �Ҹ�
     *  cnt ++
     * current < i0 ��� ���ƿ�
     *  cnt ��  �ִ� ���� ��
     *
     * ������ ���� : cnt dungeon�� ����
     * */
     visited = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            visited[i]==true;
            DFS(k, dungeons, );
        }

     DFS(k, dungeons,0);
        return k;
    }

    private void DFS(int k, int[][] dungeons, int depth) {

        while(depth<=k){

        }


    }
}
