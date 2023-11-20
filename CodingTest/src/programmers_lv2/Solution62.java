package CodingTest.src.programmers_lv2;

public class Solution62 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        /**
         * key�� ���� �� - lock�� ���� ���� ��ġ ���� �ʴ´ٸ� => ��
         * lock���� ���� �κп� �־�� ���� �¿� �̵��� �� �� ����
         * lock�� ���� ��δ� 1�̶�� �Ʒ� �̵� ����
         *        ���� ��δ� 1�̶�� ���� ������ �̵� ����
         * key�� ȸ���غ� - �ٽ� lock �� ���غ�
         * */

        int kLength = key.length;
        int lLength = lock.length;

        int extLen = lLength + (kLength)*2 -2;
        int[][] extArr = new int[extLen][extLen]; // Ȯ�� �迭

        // Ȯ�� �迭�� lock ǥ��
        for (int i = kLength-1; i < kLength+lLength-1; i++) {
            for (int j = kLength-1; j < kLength+lLength-1; j++) {
                extArr[i][j] = lock[i-(kLength-1)][j-(kLength-1)];
            }
        }

        // ȸ���ϸ鼭 4��
        for (int i = 0; i < 4; i++) {
        	// Ȯ��� �迭�ȿ� �ִ� lock + key �� ���ϴ� �۾� 
        	// �� �Ŀ� �ϳ��� 1�̶�� false
            if(check(extArr, key, lLength)){
                return true;
            }
            rotate(key);
        }

        return false;
    }

	private void rotate(int[][] key) {
		// ȸ��
		int len = key.length;
		int[][] temp = new int[len][len];
		
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// ���� k�� ���� ��ŭ �þ�� 
				// ���� 
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
		
		// Ȯ��� �迭�� ��ȸ�� 
		for (int i = 0; i < mapLen-keyLen+1; i++) {
			for (int j = 0; j < mapLen-keyLen+1; j++) {
				
				// key�� �ִ� ���ڸ� �ϳ��� �̾Ƴ��
				// Ȯ��� �迭�� ���� 
				for (int k = 0; k < keyLen; k++) {
					for (int k2 = 0; k2 < keyLen; k2++) {
						// Ȯ��� �迭 �ȿ� �ִ� lock�� ����
						extArr[i+k][j+k2] += key[k][k2];
					}
				}
				// �ڹ��� �κ��� ���� 1���� Ȯ���� 
				boolean flag = true;
				
				for (int k = keyLen-1; k < keyLen+lLength-1; k++) {
					for (int k2 = keyLen-1; k2 < keyLen+lLength-1; k2++) {
						if(extArr[k][k2]!=1) {
							// �ϳ��� 1�� �ƴ϶�� 
							flag = false;
							break;
						}
					}
					if(!flag) break;
				}
				if(flag) return true; // ���� 1�̱� ������ 
				
				// Ȯ�� �迭�� ���󺹱� 
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
