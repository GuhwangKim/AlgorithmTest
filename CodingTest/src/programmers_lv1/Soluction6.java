package programmers_lv1;

public class Soluction6 {
	class Solution {
	    public String solution(int[] numbers, String hand) {
	        String answer = "";
	        int leftindex=10;
	        int rightindex=12;
	        
	        
	        for (int i = 0; i < numbers.length; i++) {
				if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
					answer+="L";
					leftindex=numbers[i];
				} else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
					answer+="R";
					rightindex=numbers[i];
				} else {
					if(numbers[i]==0) {
						numbers[i]+=11;
					}
					int ld=(Math.abs(numbers[i]-leftindex))/3+(Math.abs(numbers[i]-leftindex))%3;
					int rd=(Math.abs(numbers[i]-rightindex))/3+(Math.abs(numbers[i]-rightindex))%3;
					
					if(ld==rd){
						if(hand.equals("left")) {
							answer+="L";
							leftindex=numbers[i];
						}
						else if(hand.equals("right")) {
							answer+="R";
							rightindex=numbers[i];
						}
					}else if(ld>rd) {
						answer+="R";
						rightindex=numbers[i];
					} else {
						answer+="L";
						leftindex=numbers[i];
					}
				}
			}
	        
	        return answer;
	    }
	}

}
