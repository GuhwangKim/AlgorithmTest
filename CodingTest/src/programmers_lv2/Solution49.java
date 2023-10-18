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
		if(cnt == 4){ // ������ ������ �տ� 4���� ����

			// ���� �����ڿ� �ش��ϴ� ���ǿ� �����ϴ� ��� ����� ���� map �� �־���
			if(!map.containsKey(str)){
				List<Integer> list = new ArrayList<>();
				map.put(str,list);
			}
			map.get(str).add(Integer.parseInt(cmbdCandidate[4]));
			// key ����, value ����
			return;
		}
		makeSentence();

	}

}
