package CodingTest.src.programmers_lv2;

import java.util.HashSet;

public class Solution58 {
	String[] userId;
	String[] banId;
	HashSet<HashSet<String>> result = new HashSet<HashSet<String>>();
	
    public int solution(String[] user_id, String[] banned_id) {
        /*
        * 1. b 배열에 원소들의 길이 기준으로 나열함
        * 2. u 배열에서 원소 값을 하나씩 빼서 b 배열과 비교함
        * 3. b>u 원소간의 길이가 큰 경우 break 그 다음 u 원소로 넘어감
        * 4. 같은 경우 글자 하나씩 비교함
        *   비교했는데 값이 같다면
        * 5. 그렇지 않은 경우 0 리턴
        *
        * */
        
        // 1. 마킹에 해당하는 값을 찾았지만 어떻게 중복처리 할 것인지 
        userId = user_id;
        banId = banned_id;
        
        DFS(new HashSet<>(), 0);

        return result.size();
    }

	private void DFS(HashSet hashSet, int depth) {
		if(depth == banId.length) {
			// 만족하는 조합임 
			result.add(hashSet);
			// set 집합 안에 set 조합을 넣어줌 
			// 조합 중복 제외 
			return;
		}
		
		for (int i = 0; i < userId.length; i++) {
			// userId 중심으로 loop
			// 조합 만들기 
			if(hashSet.contains(userId[i])) {
				// set 안에 이미 그 숫자가 있다면 
				continue;
			}
			if(check(userId[i], banId[depth])) {
				// 만족한다면 
				hashSet.add(userId[i]);
				// 그 다음 금지어로 가서 userId는 처음부터 => 
				DFS(new HashSet<>(hashSet), depth+1);
				hashSet.remove(userId[i]);
			}
		}
		
		
	}

	private boolean check(String userId, String banId) {
		// userId를 기준으로 banId를 비교함 
		
		// 1. 길이 
		if(userId.length()!=banId.length()) {
			// 다르면 비교할 것도 없음 
			return false;
		}
		// 2. 글자 하나 하나 비교 하나라도 틀리면 다름 
		boolean match = true;
		for (int i = 0; i < userId.length(); i++) {
			if(banId.charAt(i)!='*' && userId.charAt(i)!=banId.charAt(i)) {
				// 만족하지 않는 경우, * 가 없거나, 하나라도 다르면 
				match = false;
				break; // 끝 
			}
		}
		
		return match;
	}
}
