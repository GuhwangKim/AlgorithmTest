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
        // 1. ���簢�� ũ�⸦ 2��� Ȯ���Ŵ 
        int[][] map = new int[102][102];
 
        rectList = new ArrayList<>();
        // 2. ���簢�� ũ�⸦ 2��� Ȯ���Ų �迭�� ��� 
        for (int i = 0; i < rectangle.length; i++) {
        	int doubledSx = rectangle[i][0]*2;
        	int doubledSy = rectangle[i][1]*2;
        	int doubledEx = rectangle[i][2]*2;
        	int doubledEy = rectangle[i][3]*2;
        	// 3. 2��� ������Ų ���簢�� x y ��ǥ�� (���� ��) �ȿ� ���ϴ� ��ǥ�� -1�� ǥ���� 
        	for (int y = doubledSy; y <= doubledEy; y++) {
        		for (int x = doubledSx; x <= doubledEx; x++) {
					map[y][x]= -1;
				}
				
			}
        	// 4. 2��� ������ xy ���� ���� ���簢���� ��ü�� ����Ʈ�� ������� 
			rectList.add(new Rect(doubledSx, doubledSy, doubledEx, doubledEy));
		}
        // 5. BFS �� 2��� ������ xy ���� ���簢�� ��ü��, 2��� ������ ������ ĳ������ ��ǥ�� ���� 
        answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }

	static int bfs(int[][] map, int cx, int cy, int tx, int ty) {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 6. queue ���� ĳ������ (2��� ������) x y ���� �־��  , move �� �̵��� Ƚ��
		queue.add(new int[] {cx, cy, 1});
		// 7. 2��� ������ �迭�� ���� ĳ������ ��ǥ�� ǥ�� 
		map[cy][cx]=1;
		while(!queue.isEmpty()) {
			// 8. queue ���� "����" ĳ������ ��ǥ�� �̵� Ƚ���� �̾Ƴ� 
			int[] currentArr = queue.poll();
			int currentX = currentArr[0];
			int currentY = currentArr[1];
			int totalMove = currentArr[2];
			
			// 9. ĳ������ ���� ��ġ�� �������� ��ġ�� ���ٸ� �� �������� ������ ��ȯ
			if(currentX == tx && currentY == ty) {
				return (totalMove/2);
			}
			
			// 10. ĳ���ʹ� �¿���� �� 4�������� ������ �� �����Ƿ� 4������ 
			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				// 11. ���簢���� ���� �ȿ� �ְ� ��� �κ��̶�� ������ 
				if(map[nextY][nextX]<0 && isBoundary(nextX, nextY)) {
					map[nextY][nextX]= totalMove+1;
					queue.add(new int[] {nextX, nextY, totalMove+1});
					
				}
				
			}
		}
		return -1;
	}
	// 12. ��谪�� ���ϴ� ���� �迭 
	static boolean isBoundary(int x, int y) {
		// 13. ��谪�̶� = ���� ������ ������ �ȵ� + Ŀ���� �ȵ� 
		// ��谪�� ��� true
		for(Rect r : rectList) {
			if(r.x1 < x && r.y1 <y && r.x2 > x && r.y2 > y) 
				return false;
		}
		return true;
	}

}
