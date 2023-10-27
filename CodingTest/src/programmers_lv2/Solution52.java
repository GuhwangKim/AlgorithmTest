package programmers_lv2;


public class Solution52 {
	int[] answer = new int[2];
	public int[] solution(int[][] arr) {
        /**
         * 1. 행은 거듭제곱 = 반으로 쪼갤 수 있음 
         * 2. 
         * */
        int wholeSize = arr.length;
        divide(0, 0, wholeSize, arr);

        return answer;
    }

	private void divide(int x, int y, int size, int[][] arr) {
		if(check(x, y, size, arr)){
			// check시 값이 true 가 나오면
			answer[arr[x][y]]+=1;
			return;
		}

		// 1. 왼쪽위 (0,0)
		divide(x, y, size/2, arr);
		// 2. 오른쪽위 (0 half)
		divide(x, y+size/2, size/2, arr);
		//3. 왼쪽 아래 (half 0)
		divide(x+size/2, y, size/2, arr);
		//4. 오른쪽 아래 (half, half)
		divide(x+size/2, y+size/2, size/2, arr);
	}
	private boolean check(int x, int y, int size, int[][] arr) {
		for (int j = x; j < x+size ; j++) {
			for (int i = y; i < y+size; i++) {
				if(arr[x][y]!=arr[j][i]){
					return false;
				}
			}
		}
		return true;
	}
}
