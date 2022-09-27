package programmers_lv1;

public class Solution31 {
    public boolean solution(int x) {
        boolean answer = false;
        
        String str=Integer.toString(x);
        
        int[] ha = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
			ha[i]=str.charAt(i)-'0';
		}
        
        int sum=0;
        
        for (int i = 0; i < ha.length; i++) {
			sum+=ha[i];
		}
        
        if(x%sum==0) {
        	answer=true;
        }
        
        return answer;
    }
}
