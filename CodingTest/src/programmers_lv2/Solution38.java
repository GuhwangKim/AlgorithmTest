package programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class Solution38 {
	static ArrayList<Integer>[] childs;
	static int[] Info;
	static int maxSheepCnt = 0;
	
	public int solution(int[] info, int[][] edges) {
		Info = info;
		childs = new ArrayList[info.length];
		for(int[] arr : edges) {
			int parent = arr[0];
			int child = arr[1];
			if(childs[parent]==null) {
				// parent �ε����� ���� child Integer ������ ����� => �迭�� ���·� 
				childs[parent] = new ArrayList<Integer>();
			}
			childs[parent].add(child);
			
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		DFS(0, 0, 0, list);
		
		return maxSheepCnt;
	}

	private static void DFS(int idx, int sheepCnt, int wolfCnt, List<Integer> childList) {
		if(Info[idx]==0) {
			sheepCnt++;
		// ���� ��� �� ���� ���� 
		}else {
			wolfCnt++;
		}
		
		if(wolfCnt>=sheepCnt) {
			return;
			// ������ ������ ���� �������� ���ų� ������ �� 
		}
		maxSheepCnt = Math.max(sheepCnt, maxSheepCnt);
		
		// ���� Ž�� ����
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(childList);
		list.remove(Integer.valueOf(idx));
		// ���� idx �� �����ϰ� �ٸ� �͵��� Ÿ���� 
		if(childs[idx]!=null) {
			for(int child : childs[idx]) {
				list.add(child);
				// �θ� ��忡 ����Ǿ��ִ� child ����� �ε������� list�� ���� 
			}
		}
		
		for(int next : list) {
			DFS(next, sheepCnt, wolfCnt, list);
		}
		
	}
}
