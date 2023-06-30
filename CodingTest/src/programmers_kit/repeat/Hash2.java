package programmers_kit.repeat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Hash2 {
	/**
	 * 1. 여기서 value 값에 들어가는 값은 정확하게 중요하지 않음 
	 * 2. 오직 개수만이 중요하기 때문에 Hash의 value 값을 Integer로 주는 것이 합리적
	 * 3. 총 가지 수는 +1 씩 해서 서로 곱하고 1개를 빼줌 
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
//			map.put(clothes[i][1], map.get(clothes[i][1]).add(clothes[i][0])); 여기서 기존에 있는 리스트에 값을 넣기 애매함 
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
