package CodingTest.src.programmers_lv2;

public class Solution62 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        /**
         * key에 원소 값 - lock의 원소 값이 일치 하지 않는다면 => 끝
         * lock값이 막힌 부분에 있어서는 상하 좌우 이동을 할 수 있음
         * lock의 행이 모두다 1이라면 아래 이동 가능
         *        열이 모두다 1이라면 왼쪽 오른쪽 이동 가능
         * key를 회전해봄 - 다시 lock 과 비교해봄
         * */

        int kLength = key.length;
        int lLength = lock.length;

        int extLen = lLength + (kLength)*2 -2;
        int[][] extArr = new int[extLen][extLen]; // 확장 배열

        // 확장 배열에 lock 표시
        for (int i = kLength-1; i < kLength+lLength-1; i++) {
            for (int j = kLength-1; j < kLength+lLength-1; j++) {
                extArr[i][j] = lock[i-(kLength-1)][j-(kLength-1)];
            }
        }

        // 회전하면서 4번
        for (int i = 0; i < 4; i++) {
        	// 확장된 배열안에 있는 lock + key 를 더하는 작업 
        	// 그 후에 하나라도 1이라면 false
            if(check(extArr, key, lLength)){
                return true;
            }
            rotate(key);
        }

        return false;
    }

	private void rotate(int[][] key) {
		// 회전
		int len = key.length;
		int[][] temp = new int[len][len];
		
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// 행이 k의 길이 만큼 늘어나고 
				// 열은 
				temp[i][j] = key[len-j-1][i];
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				key[i][j] = temp[i][j];
			}
		}
		
	}

	private boolean check(int[][] extArr, int[][] key, int lLength) {
		int keyLen = key.length;
		int mapLen = extArr.length;
		
		// 확장된 배열을 순회함 
		for (int i = 0; i < mapLen-keyLen+1; i++) {
			for (int j = 0; j < mapLen-keyLen+1; j++) {
				
				// key에 있는 글자를 하나씩 뽑아내어서
				// 확장된 배열에 더함 
				for (int k = 0; k < keyLen; k++) {
					for (int k2 = 0; k2 < keyLen; k2++) {
						// 확장된 배열 안에 있는 lock에 더함
						extArr[i+k][j+k2] += key[k][k2];
					}
				}
				// 자물쇠 부분이 전부 1인지 확인함 
				boolean flag = true;
				
				for (int k = keyLen-1; k < keyLen+lLength-1; k++) {
					for (int k2 = keyLen-1; k2 < keyLen+lLength-1; k2++) {
						if(extArr[k][k2]!=1) {
							// 하나라도 1이 아니라면 
							flag = false;
							break;
						}
					}
					if(!flag) break;
				}
				if(flag) return true; // 전부 1이기 때문에 
				
				// 확장 배열을 원상복귀 
				for (int k = 0; k < keyLen; k++) {
					for (int k2 = 0; k2 < keyLen; k2++) {
						extArr[i+k][j+k2] -= key[k][k2];
					}
				}
				
			}
		}
		return false;
	}
	
}
