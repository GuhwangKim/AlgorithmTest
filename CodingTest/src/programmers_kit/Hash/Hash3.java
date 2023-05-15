package programmers_kit.Hash;

import java.util.Collection;
import java.util.HashMap;

public class Hash3 {
	public static void main(String[] args) {
		Hash3 h = new Hash3();
		String cloth[][]= 
			 {{"crow_mask", "face"}
			 ,{"blue_sunglasses", "face"}
			 , {"smoky_makeup", "face"}};
		 
		h.solution(cloth);
	}
	 public int solution(String[][] clothes) {
		 
	        int answer = 0;
			// ������ �ǻ��� ������ ���� ���ϱ� 
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        
	        for (int i = 0; i < clothes.length; i++) {
	        	String key = clothes[i][1];
	        	if(!map.containsKey(key)) {
	        		map.put(key, 1);
	        		// ó�� ������ �ǻ��� ������� 1�� ���� 
	        	} else {
	        		map.put(key, map.get(key)+1);
	        		// �ߺ��� �ȴٸ� ������ �־��� ������ �Ѱ��� ���� �߰� 
	        	}
			}
	        
	        Collection<Integer> values = map.values();
	        answer = values.stream().reduce((x,y)->(x+1)*(y+1)).get()-1;
	        System.out.println(answer);
	        
	        
	        
	        return answer;
	    }

}
