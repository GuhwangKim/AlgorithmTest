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
				// parent 인덱스에 속한 child Integer 값들을 담아줌 => 배열의 형태로 
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
		// 양인 경우 양 개수 증가 
		}else {
			wolfCnt++;
		}
		
		if(wolfCnt>=sheepCnt) {
			return;
			// 늑대의 개수가 양의 개수보다 많거나 같으면 끝 
		}
		maxSheepCnt = Math.max(sheepCnt, maxSheepCnt);
		
		// 다음 탐색 갱신
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(childList);
		list.remove(Integer.valueOf(idx));
		// 현재 idx 는 제거하고 다른 것들을 타야함 
		if(childs[idx]!=null) {
			for(int child : childs[idx]) {
				list.add(child);
				// 부모 노드에 연결되어있는 child 노드의 인덱스들을 list에 담음 
			}
		}
		
		for(int next : list) {
			DFS(next, sheepCnt, wolfCnt, list);
		}
		
	}
}
