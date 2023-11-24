package CodingTest.src.programmers_lv2;

public class Solution65 {
	static int[] dc = {0, -1, 0, 1};
	static int[] dr = {-1, 0, 1, 0};
	public int solution(String dirs) {
        int answer = 0;

        boolean[][][] visited = new boolean[11][11][4]; // 방향까지 

        int curC = 5;
        int curR = 5;
      

        for (int i = 0; i < dirs.length(); i++) {
            char currAlpha = dirs.charAt(i);
            int d = 0;
            if(currAlpha =='U'){
                // 위
            	d = 0;

            } else if (currAlpha == 'L') {
                // 오른쪽
            	d = 1;

            } else if (currAlpha == 'D') {
                // 아래
            	d = 2;

            } else{
                // 오른쪽
            	d = 3;
            }
            
            int nextC = curC + dc[d];
            int nextR = curR + dr[d];
            
            if(nextC < 0 || nextR <0 || nextC > 10 || nextR > 10) {
            	// 범위를 초과하면 
            	continue;
            }
            if(!visited[nextR][nextC][d]) {
            	// 한번도 지나간적이 없다면
            	visited[nextR][nextC][d] = true;
            	// 방문
            	d = (d%2 == 0 )? 2-d : 4-d;
            	// 반대쪽도 방문 완료 
            	visited[curR][curC][d] = true;
            	answer++; // 방문 체크 
            }
            curR = nextR;
            curC = nextC;
        }
        return answer;
    }
}
