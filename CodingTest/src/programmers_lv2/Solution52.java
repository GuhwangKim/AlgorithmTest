package programmers_lv2;

public class Solution52 {
	int[] answer = new int[2];
	public int[] solution(int[][] arr) {
        
                
        /**
         * 1. ���� �ŵ����� = ������ �ɰ� �� ���� 
         * 2. 
         * */
        
        int half = arr.length/2;
        square(half, arr);
       
        
        return answer;
    }

	private void square(int half, int[][] arr) {
		if(half==1) {
			// ���� �۰� ������ 
			answer[arr[0][0]] +=1;
		}
		 // 1. ù��° �簢�� 
        boolean flag1 = false;
        int firstNum1 = arr[0][0];
        for (int i = 0; i < half; i++) {
        	for (int j = 0; j < half; j++) {
				if(firstNum1!=arr[i][j]) {
					// �ٸ��� �ϳ��� �ִٸ� �ٽ� �������� 
					flag1= true;
					break;
				}
			}
        	if(flag1) {
        		// �ٸ��� �ϳ��� ������ �� �ٽ� �������� 
        		break;
        	}
			
		}
        if(!flag1) {
        	// ������ false = ��� ���� ���� 
        	answer[firstNum1] +=1;
        }
        
        // 2. 2��° �簢�� 
        boolean flag2 = false;
        int firstNum2 = arr[0][half];
        for (int i = 0; i < half; i++) {
			for (int j = half; j < arr.length; j++) {
				if(firstNum2!=arr[i][j]) {
					// �ٸ��� �ϳ��� �ִٸ� �ٽ� �������� 
					flag2= true;
					break;
				}
				
			}
			if(flag2) {
        		// �ٸ��� �ϳ��� ������ �� �ٽ� �������� 
        		break;
        	}
			
		}
        if(!flag2) {
        	// ������ false = ��� ���� ���� 
        	answer[firstNum2] +=1;
        } else {
        	// half�� ������ �ٽ� ����� ���� 
        	int newhalf = half/2;
        	square(newhalf, arr);
        }
        
        
        // 3.3��° �簢��
        boolean flag3 = false;
        int firstNum3 = arr[half][0];
        for (int i = half; i < arr.length; i++) {
        	for (int j = 0; j < half; j++) {
				
			}
			
		}
        // 4. 4��° �簢�� 
        boolean flag4 = false;
        int firstNum4 = arr[half][half];
        for (int i = half; i < arr.length; i++) {
			for (int j = half; j < arr.length; j++) {
				
			}
		}
		
	}

}
