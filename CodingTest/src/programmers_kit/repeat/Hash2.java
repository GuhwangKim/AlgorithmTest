package programmers_kit.repeat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Hash2 {
	/**
	 * 1. ���⼭ value ���� ���� ���� ��Ȯ�ϰ� �߿����� ���� 
	 * 2. ���� �������� �߿��ϱ� ������ Hash�� value ���� Integer�� �ִ� ���� �ո���
	 * 3. �� ���� ���� +1 �� �ؼ� ���� ���ϰ� 1���� ���� 
	 * 
	 * */
	
	public int solution(String[][] clothes) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			} else {
				map.put(clothes[i][1], 1);
			}
		}
		Collection<Integer> values = map.values();
        int answer = values.stream().reduce((x,y)->(x+1)*(y+1)).get()-1;

		return answer;
	}
}

//public int solution(String[][] clothes) {
//	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
//	for (int i = 0; i < clothes.length; i++) {
//		if (map.containsKey(clothes[i][1])) {
//			map.put(clothes[i][1], map.get(clothes[i][1]).add(clothes[i][0])); ���⼭ ������ �ִ� ����Ʈ�� ���� �ֱ� �ָ��� 
//		} else {
//			List<String> list = new ArrayList<String>();
//			list.add(clothes[i][0]);
//			map.put(clothes[i][1], list);
//		}
//	}
//	int count = 1;
//	
//	for (int i = 0; i < map.size(); i++) {
//		count *= map.get(i).size()+1;
//	}
//
//	return clothes.length + count;
//}
