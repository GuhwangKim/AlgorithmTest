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

        //1. �ڽ� ���ĺ� ������ ������ 
        for (int i = 0; i < orders.length; i++) {
			char[] argdOrders = orders[i].toCharArray();
			// ���ڸ� �ϳ� �ϳ� �̾Ƽ� �迭�� �־��ְ� ����
			Arrays.sort(argdOrders);
			argdStrOrder = String.copyValueOf(argdOrders);
			
			// 2. �ڽ��� ���� ���� �����ϴ� ��� ��ǰ�� ������ ���� 
			for (int j = 0; j < course.length; j++) {
				isVisited = new boolean[argdStrOrder.length()];
				// ������ ��¥ ���� �湮�ߴ��� ǥ�� 
				comb(0, 0, "", j, course[j]);
				
			}
			
		}
        
        for(String string : menu.keySet()) {
        	// 4. �޴��� ��� ������ ��� �޴��鿡 ���ؼ� 
        	for (int i = 0; i < course.length; i++) {
				if(course[i]==string.length() && max[i]!=1 && menu.get(string)==max[i]) {
					// ã�� �ڽ��� ���� ��ŭ && 2ȸ �̻� && ���� ��� ���տ��� ���� ���� ���� �ִ��϶� 
					answer.add(string);
					// �������
				}
			}
        }
        return answer.stream().sorted().map(s -> s).toArray(String[]::new);
        // ���� ���ķ� �����ؼ� String[] ���¿� ��Ƶ� 
    }

	private void comb(int currentIdx, int currentMenuCnt, String currentCombdMenu, int courseIdx, int courseVal) { // 2���� =? 3���� ��ǰ 
		if(currentMenuCnt==courseVal) {
			// 3. �ڽ����� ã�� �ִ� ����
			menu.put(currentCombdMenu, menu.containsKey(currentCombdMenu)?menu.get(currentCombdMenu)+1 : 1);
			// ���� ������ ������ ������ ���������� 
			max[courseIdx] = Math.max(max[courseIdx], menu.get(currentCombdMenu));
			// ã�� �ִ� ��ǰ�� ������ �迭�� ������ ��¥�� ���� �� �ִ븦 �� 
			return;
			
		}
		for (int i = currentIdx; i < argdStrOrder.length(); i++) {
			isVisited[i] = true;
			// ���� �ε����� �������� ��� ����� 
			comb(i+1, currentMenuCnt+1, currentCombdMenu+argdStrOrder.charAt(i), courseIdx, courseVal); //courseIdx �������� �Ѿ��
		}
		
	}
}
