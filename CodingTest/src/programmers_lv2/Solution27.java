package programmers_lv2;

public class Solution27 {
	
	public static void main(String[] args) {
		Solution27 solution = new Solution27();
		solution.solution(1, 5);
	}
	
    public long solution(int k, int d) {
        long answer = 0;

        for (long i = 0; i <= d; i+=k) { //x에서 시작 0 1*k 2*k 3*k ....d
            
           answer += (long)Math.sqrt(Math.pow(d, 2)-Math.pow(i, 2))/k+1;

        }

        return answer;
    }
}
