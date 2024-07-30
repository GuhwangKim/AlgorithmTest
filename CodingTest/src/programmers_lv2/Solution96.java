package CodingTest.src.programmers_lv2;

public class Solution96 {
    static int cnt;
    boolean[] visited;
    int[] answer;
    public int[] solution(int n, long k) {
        answer = new int[n];
        int[] temp = new int[n];
        visited = new boolean[n]; // �湮�� �迭�� �������� ����
        DFS(0,temp, k);
        return answer;
    }

    public void DFS(int ord, int[] temp, long k) {
        if(ord == temp.length){
            // ���� ������ ���̱��� ��
            cnt++; // ���ǿ� �����ϴ� �迭�� ���� �����ֱ�
            if (cnt == k) {
                // �ش��ϴ� �������
                for (int i = 0; i < temp.length; i++) {
                    answer[i] = temp[i];
                }
            }
            return;
        }
        for (int i = 0; i < temp.length ; i++) {
            if (!visited[i]) {
                // �湮���� �ʾҴٸ�
                visited[i] = true;
                temp[ord] = i+1;// ���� ��� ���� �ٲ�� �־���
                DFS(ord + 1, temp, k);
                visited[i] = false;

            }
        }
    }
}
