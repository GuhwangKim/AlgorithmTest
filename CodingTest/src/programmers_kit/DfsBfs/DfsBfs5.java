package programmers_kit.DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsBfs5 {
	
	static class Rect{
		int x1, x2, y1, y2;

		public Rect(int x1, int x2, int y1, int y2) {
			super();
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	
	static int x, y;
	static List<Rect> rectList;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 1. 직사각형 크기를 2배로 확장시킴 
        int[][] map = new int[102][102];
 
        rectList = new ArrayList<>();
        // 2. 직사각형 크기를 2배로 확장시킨 배열에 담기 
        for (int i = 0; i < rectangle.length; i++) {
        	int doubledSx = rectangle[i][0]*2;
        	int doubledSy = rectangle[i][1]*2;
        	int doubledEx = rectangle[i][2]*2;
        	int doubledEy = rectangle[i][3]*2;
        	// 3. 2배로 증가시킨 직사각형 x y 좌표에 (시작 끝) 안에 속하는 좌표를 -1로 표시함 
        	for (int y = doubledSy; y <= doubledEy; y++) {
        		for (int x = doubledSx; x <= doubledEx; x++) {
					map[y][x]= -1;
				}
				
			}
        	// 4. 2배로 증가된 xy 값을 가진 직사각형의 객체를 리스트에 집어넣음 
			rectList.add(new Rect(doubledSx, doubledSy, doubledEx, doubledEy));
		}
        // 5. BFS 에 2배로 증가된 xy 값의 직사각형 객체와, 2배로 증가된 아이템 캐릭터의 좌표를 보냄 
        answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }

	static int bfs(int[][] map, int cx, int cy, int tx, int ty) {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 6. queue 값애 캐릭터의 (2배로 증가됨) x y 값을 넣어둠  , move 는 이동한 횟수
		queue.add(new int[] {cx, cy, 1});
		// 7. 2배로 증가된 배열에 현재 캐릭터의 좌표를 표시 
		map[cy][cx]=1;
		while(!queue.isEmpty()) {
			// 8. queue 값에 "현재" 캐릭터의 좌표와 이동 횟수를 뽑아냄 
			int[] currentArr = queue.poll();
			int currentX = currentArr[0];
			int currentY = currentArr[1];
			int totalMove = currentArr[2];
			
			// 9. 캐릭터의 현재 위치와 아이템의 위치가 같다면 총 움직임의 절반을 반환
			if(currentX == tx && currentY == ty) {
				return (totalMove/2);
			}
			
			// 10. 캐릭터는 좌우상하 총 4방향으로 움직일 수 있으므로 4개까지 
			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				// 11. 직사각형의 범주 안에 있고 경계 부분이라면 움직임 
				if(map[nextY][nextX]<0 && isBoundary(nextX, nextY)) {
					map[nextY][nextX]= totalMove+1;
					queue.add(new int[] {nextX, nextY, totalMove+1});
					
				}
				
			}
		}
		return -1;
	}
	// 12. 경계값을 구하는 가상 배열 
	static boolean isBoundary(int x, int y) {
		// 13. 경계값이란 = 내부 안으로 들어오면 안됨 + 커서도 안됨 
		// 경계값인 경우 true
		for(Rect r : rectList) {
			if(r.x1 < x && r.y1 <y && r.x2 > x && r.y2 > y) 
				return false;
		}
		return true;
	}

}
