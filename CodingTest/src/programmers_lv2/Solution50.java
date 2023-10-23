package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution50 {
	static String argdStrOrder;
	static HashMap<String, Integer> menu;
	static boolean isVisited[];
	static int max[];
	
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<String>();
		max = new int[course.length];
		menu = new HashMap<String, Integer>();

        //1. 코스 알파벳 순으로 정렬함 
        for (int i = 0; i < orders.length; i++) {
			char[] argdOrders = orders[i].toCharArray();
			// 글자를 하나 하나 뽑아서 배열에 넣어주고 정렬
			Arrays.sort(argdOrders);
			argdStrOrder = String.copyValueOf(argdOrders);
			
			// 2. 코스의 개수 별로 만족하는 모든 단품의 결합을 구함 
			for (int j = 0; j < course.length; j++) {
				isVisited = new boolean[argdStrOrder.length()];
				// 합쳐진 글짜 별로 방문했는지 표시 
				comb(0, 0, "", j, course[j]);
				
			}
			
		}
        
        for(String string : menu.keySet()) {
        	// 4. 메뉴에 담긴 가능한 모든 메뉴들에 대해서 
        	for (int i = 0; i < course.length; i++) {
				if(course[i]==string.length() && max[i]!=1 && menu.get(string)==max[i]) {
					// 찾는 코스의 길이 만큼 && 2회 이상 && 현재 담긴 조합에서 나온 값이 가장 최대일때 
					answer.add(string);
					// 집어넣음
				}
			}
        }
        return answer.stream().sorted().map(s -> s).toArray(String[]::new);
        // 답을 정렬로 저장해서 String[] 형태에 담아둠 
    }

	private void comb(int currentIdx, int currentMenuCnt, String currentCombdMenu, int courseIdx, int courseVal) { // 2번쨰 =? 3개의 단품 
		if(currentMenuCnt==courseVal) {
			// 3. 코스에서 찾고 있는 길이
			menu.put(currentCombdMenu, menu.containsKey(currentCombdMenu)?menu.get(currentCombdMenu)+1 : 1);
			// 같은 조합이 있으면 개수만 증가시켜줌 
			max[courseIdx] = Math.max(max[courseIdx], menu.get(currentCombdMenu));
			// 찾고 있는 단품의 개수의 배열에 합쳐진 글짜의 개수 와 최대를 비교 
			return;
			
		}
		for (int i = currentIdx; i < argdStrOrder.length(); i++) {
			isVisited[i] = true;
			// 현재 인덱스를 기준으로 계속 뻗어나감 
			comb(i+1, currentMenuCnt+1, currentCombdMenu+argdStrOrder.charAt(i), courseIdx, courseVal); //courseIdx 상위에서 넘어옴
		}
		
	}
}
