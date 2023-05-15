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
			// 각각의 의상의 종류의 개수 구하기 
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        
	        for (int i = 0; i < clothes.length; i++) {
	        	String key = clothes[i][1];
	        	if(!map.containsKey(key)) {
	        		map.put(key, 1);
	        		// 처음 나오는 의상의 종류라면 1로 세팅 
	        	} else {
	        		map.put(key, map.get(key)+1);
	        		// 중복이 된다면 기존에 있었던 값에서 한개씩 값을 추가 
	        	}
			}
	        
	        Collection<Integer> values = map.values();
	        answer = values.stream().reduce((x,y)->(x+1)*(y+1)).get()-1;
	        System.out.println(answer);
	        
	        
	        
	        return answer;
	    }

}
