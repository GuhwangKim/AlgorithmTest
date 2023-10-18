package CodingTest.src.programmers_lv2;

import java.util.*;

import programmers_kit.Search.BinarySearch1;

public class Solution49 {
	static HashMap<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();
		for(String candidate : info){
			String[] ability = candidate.split(" ");
			makeSentence(ability, "", 0);
		}
			
		// 지원자의 조건을 뽑아서 조건을 기준으로 오름차순 정렬
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		
		// 점수 기준
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] requirement = query[i].split(" "); // 배열의 길이는 2개 (조건 / 점수) 
			answer[i] = map.containsKey(requirement[0])?binarySearch1(requirement[0], Integer.parseInt(requirement[1])):0;
			// 만족하는 것이 있다면 메소드, 그렇지 않으면 0 
		}
		return answer;
    }

	private int binarySearch1(String requirement , int score) { // 점수 score 이상 받은 사람의 수 
		List<Integer> list = map.get(requirement);
		// 점수들
		int start = 0 ;
		int end = list.size()-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(list.get(mid)<score) {
				start = mid+1;
			}else {
				end = mid -1;
			}
		}
		// 정확한 수를 찾기 위해서 나누고 또 나눔
		
		return list.size()-start;
	}

	private void makeSentence(String[] ability, String str, int cnt) {
		if(cnt == 4){ // 점수를 제외한 앞에 4가지 조건

			// 현재 지원자에 해당하는 조건에 만족하는 모든 경우의 수를 map 에 넣어줌
			if(!map.containsKey(str)){
				List<Integer> list = new ArrayList<>();
				map.put(str,list);
			}
			map.get(str).add(Integer.parseInt(ability[4]));
			// key 조건, value 점수 (점수는 경우의 수가 없기 떄문에 리스트로 넣어주어야함) 
			return;
		}
		makeSentence(ability, str+"-", cnt+1); // 조건 없음을 적당히 섞음 
		makeSentence(ability, str+ability[cnt], cnt+1); // 현재의 글자를 넣음 

	}

}
