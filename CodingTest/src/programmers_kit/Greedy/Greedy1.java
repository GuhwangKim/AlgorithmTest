package programmers_kit.Greedy;

public class Greedy1 {
	public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        
        // 1) 위 아래로 움직임 원리 : 해당 글자의 - A / 전체에서 (해당글 - A) 더 짧은 쪽으로 올라감 
        // 2) 인덱스 안의 값 중에, 그 다음값이 A 인 경우 
        
        for (int i = 0; i < name.length(); i++) {
			answer+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i));
			
			// 그 다음수가 A 라면 A의 마지막 위치 찾음 
			int idxNow = i + 1;
			while(idxNow<name.length()&&name.charAt(idxNow)=='A') {
				idxNow++;
			}
			
			
			
		}
        
        
        return answer;
    }

}
