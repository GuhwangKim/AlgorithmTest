package programmers_lv2;

public class Solution52 {
	int[] answer = new int[2];
	public int[] solution(int[][] arr) {
        
                
        /**
         * 1. 행은 거듭제곱 = 반으로 쪼갤 수 있음 
         * 2. 
         * */
        
        int half = arr.length/2;
        square(half, arr);
       
        
        return answer;
    }

	private void square(int half, int[][] arr) {
		if(half==1) {
			// 가장 작게 떨어짐 
			answer[arr[0][0]] +=1;
		}
		 // 1. 첫번째 사각형 
        boolean flag1 = false;
        int firstNum1 = arr[0][0];
        for (int i = 0; i < half; i++) {
        	for (int j = 0; j < half; j++) {
				if(firstNum1!=arr[i][j]) {
					// 다른게 하나라도 있다면 다시 나눠야함 
					flag1= true;
					break;
				}
			}
        	if(flag1) {
        		// 다른게 하나라도 있으면 끝 다시 나눠야함 
        		break;
        	}
			
		}
        if(!flag1) {
        	// 끝까지 false = 모든 값이 같음 
        	answer[firstNum1] +=1;
        }
        
        // 2. 2번째 사각형 
        boolean flag2 = false;
        int firstNum2 = arr[0][half];
        for (int i = 0; i < half; i++) {
			for (int j = half; j < arr.length; j++) {
				if(firstNum2!=arr[i][j]) {
					// 다른게 하나라도 있다면 다시 나눠야함 
					flag2= true;
					break;
				}
				
			}
			if(flag2) {
        		// 다른게 하나라도 있으면 끝 다시 나눠야함 
        		break;
        	}
			
		}
        if(!flag2) {
        	// 끝까지 false = 모든 값이 같음 
        	answer[firstNum2] +=1;
        } else {
        	// half를 반으로 다시 나누어서 진행 
        	int newhalf = half/2;
        	square(newhalf, arr);
        }
        
        
        // 3.3번째 사각형
        boolean flag3 = false;
        int firstNum3 = arr[half][0];
        for (int i = half; i < arr.length; i++) {
        	for (int j = 0; j < half; j++) {
				
			}
			
		}
        // 4. 4번째 사각형 
        boolean flag4 = false;
        int firstNum4 = arr[half][half];
        for (int i = half; i < arr.length; i++) {
			for (int j = half; j < arr.length; j++) {
				
			}
		}
		
	}

}
