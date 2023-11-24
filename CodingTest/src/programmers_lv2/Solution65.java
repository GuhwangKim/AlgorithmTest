package CodingTest.src.programmers_lv2;

public class Solution65 {
	static int[] dc = {0, -1, 0, 1};
	static int[] dr = {-1, 0, 1, 0};
	public int solution(String dirs) {
        int answer = 0;

        boolean[][][] visited = new boolean[11][11][4]; // ������� 

        int curC = 5;
        int curR = 5;
      

        for (int i = 0; i < dirs.length(); i++) {
            char currAlpha = dirs.charAt(i);
            int d = 0;
            if(currAlpha =='U'){
                // ��
            	d = 0;

            } else if (currAlpha == 'L') {
                // ������
            	d = 1;

            } else if (currAlpha == 'D') {
                // �Ʒ�
            	d = 2;

            } else{
                // ������
            	d = 3;
            }
            
            int nextC = curC + dc[d];
            int nextR = curR + dr[d];
            
            if(nextC < 0 || nextR <0 || nextC > 10 || nextR > 10) {
            	// ������ �ʰ��ϸ� 
            	continue;
            }
            if(!visited[nextR][nextC][d]) {
            	// �ѹ��� ���������� ���ٸ�
            	visited[nextR][nextC][d] = true;
            	// �湮
            	d = (d%2 == 0 )? 2-d : 4-d;
            	// �ݴ��ʵ� �湮 �Ϸ� 
            	visited[curR][curC][d] = true;
            	answer++; // �湮 üũ 
            }
            curR = nextR;
            curC = nextC;
        }
        return answer;
    }
}
