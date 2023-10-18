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
			
		// �������� ������ �̾Ƽ� ������ �������� �������� ����
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		
		// ���� ����
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] requirement = query[i].split(" "); // �迭�� ���̴� 2�� (���� / ����) 
			answer[i] = map.containsKey(requirement[0])?binarySearch1(requirement[0], Integer.parseInt(requirement[1])):0;
			// �����ϴ� ���� �ִٸ� �޼ҵ�, �׷��� ������ 0 
		}
		return answer;
    }

	private int binarySearch1(String requirement , int score) { // ���� score �̻� ���� ����� �� 
		List<Integer> list = map.get(requirement);
		// ������
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
		// ��Ȯ�� ���� ã�� ���ؼ� ������ �� ����
		
		return list.size()-start;
	}

	private void makeSentence(String[] ability, String str, int cnt) {
		if(cnt == 4){ // ������ ������ �տ� 4���� ����

			// ���� �����ڿ� �ش��ϴ� ���ǿ� �����ϴ� ��� ����� ���� map �� �־���
			if(!map.containsKey(str)){
				List<Integer> list = new ArrayList<>();
				map.put(str,list);
			}
			map.get(str).add(Integer.parseInt(ability[4]));
			// key ����, value ���� (������ ����� ���� ���� ������ ����Ʈ�� �־��־����) 
			return;
		}
		makeSentence(ability, str+"-", cnt+1); // ���� ������ ������ ���� 
		makeSentence(ability, str+ability[cnt], cnt+1); // ������ ���ڸ� ���� 

	}

}
