package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution49 {
	static HashMap<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();
		for(String candidate : info){
			String[] cmbdCandidate = candidate.split(" ");
			makeSentence(cmbdCandidate, "", 0);
		}

		return answer;
    }

	private void makeSentence(String[] cmbdCandidate, String str, int cnt) {
		if(cnt == 4){ // 점수를 제외한 앞에 4가지 조건

			// 현재 지원자에 해당하는 조건에 만족하는 모든 경우의 수를 map 에 넣어줌
			if(!map.containsKey(str)){
				List<Integer> list = new ArrayList<>();
				map.put(str,list);
			}
			map.get(str).add(Integer.parseInt(cmbdCandidate[4]));
			// key 조건, value 점수
			return;
		}
		makeSentence();

	}

}
