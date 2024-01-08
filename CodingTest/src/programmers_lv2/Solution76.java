package CodingTest.src.programmers_lv2;

public class Solution76 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // m n 으로 이루어진 보드를 만듦
        char[][] map = new char[m][n];
        // 각 행별로 값을 한번에 집어넣음
        for (int i = 0; i < m; ++i) {
            map[i] = board[i].toCharArray();
        }

        // 더이상 없앨 게 없을 때 끝냄
        while(true){
            int cnt = checkBlock(m,n,map);
            if(cnt==0){
                break;
            }
            answer+=cnt;
            dropBlock(m,n,map);
        }

        return answer;
    }

    private void dropBlock(int m, int n, char[][] map) {
        // 같은 블럭들이 사라지는 작업
        for (int c = 0; c < n; ++c) { // 행
            for (int r = m-1; r >= 0; --r) {
                // 아래 부터 올라옴
                if(map[r][c] == '.'){
                    // 존재하지 않을 때
                    for (int nr = r-1; nr >= 0 ; --nr) {
                        // 위에 있는 값이 내려옴
                        if(map[nr][c] != '.'){
                            // 위에 값이 존재하면 내려옴
                            map[r][c] = map[nr][c];
                            // 위에 값은 공백이 됨
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }

        }
    }

    private int checkBlock(int m, int n, char[][] map) {
        // 몇개가 사라질 까 같은 블록을 확인하는 작업
        int cnt = 0;
        boolean[][] checked = new boolean[m][n];

        for (int i = 0; i < m-1; ++i) {
            for (int j = 0; j < n-1; ++j) {
            	if(map[i][j] == '.') {
            		// 아무것도 없다면 
            		continue;
            	}
            	checkFour(map, checked, i, j);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
            	if(checked[i][j]) {
            		// 4면이 같은 것이 존재함 
            		cnt++;
            		map[i][j] = '.';
            		// 없어져야하기 때문에 변경함 
            	}
            }
        }
        return cnt;
    }

	private void checkFour(char[][] map, boolean[][] checked, int i, int j) {
		char block = map[i][j];
		// 현재의 위치 정보 
		for (int k = i; k < i+2; ++k) {
			for (int k2 = j; k2 < j+2; ++k2) {
				if(map[k][k2] != block) {
					//현재의 위치에서 좌우상하 
					return;
				}
			}
		}
		for (int k = i; k < i+2; ++k) {
			for (int k2 = j; k2 < j+2; ++k2) {
				checked[k][k2] = true;
			}
		}
	}
}
