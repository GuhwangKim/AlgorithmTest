package programmers_kit.Search;

public class Search2 {
	public static void main(String[] args) {
		Search2 s = new Search2();
		s.solution(24, 24);
	}
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int maxLen = (int)Math.sqrt(yellow);
        int x = yellow;
        for (int y = 1;  y <= maxLen;  y++) {
			if(yellow%y==0) {
				x=(yellow/y);
				if((x*2)+(y*2)+4==brown){
					answer[0]=Math.max(x+2, y+2);
					answer[1]=Math.min(x+2, y+2);
					break;
				} 
			}
		}
        return answer;
    }

}
