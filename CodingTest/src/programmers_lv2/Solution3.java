package programmers_lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
	class Solution {
		public int[] solution(int[] fees, String[] records) {
			// String �� ��� ������ұ�
			int[] answer = {};
			
			Map<String, String> map = new HashMap<String, String>();
			Map<String, Integer> fmap = new HashMap<String, Integer>();
			
			for (int i = 0; i < records.length; i++) {
				fmap.put(records[i].split(" ")[1], 0);
			}

			for (int i = 0; i < records.length; i++) {
				String[] infos = records[i].split(" ");
				if(map.containsKey(infos[1])) { // �ƿ��� �ð��� �ִ� ���  
					String[] inTime=map.remove(infos[1]).split(":"); // (����) info1�� �� (�ð�) ������ ����
					String[] outTime=infos[0].split(":"); // ���߿� ã�� �� 
					
					// �ð� �� ��ȯ 
					int hour = Integer.parseInt(outTime[0])-Integer.parseInt(inTime[0]); 
					int minute = Integer.parseInt(outTime[1])-Integer.parseInt(inTime[1]); 
					
					// �� ��ȣ Ű�� �� ���� �ð� ����� 
					// �ð��� �� ������  (�ð�*60��)
					fmap.replace(infos[1], fmap.get(infos[1])+60*hour+minute);
				} else {// ó�� ���� �ð�  
					map.put(infos[1], infos[0]);
				}
			}
			for(String key : map.keySet()) { // �ƿ����� ���� ��� 
				String[] inTime=map.get(key).split(":");
				int hour = 23-Integer.parseInt(inTime[0]); 
				int minute = 59-Integer.parseInt(inTime[1]); 
				
				fmap.replace(key, fmap.get(key)+60*hour+minute);
			}
			
			// ���� ��ȣ ���� 
			List<Map.Entry<String, Integer>> list = new ArrayList(fmap.entrySet());
			Collections.sort(list, (o1, o2)->{
				return Integer.parseInt(o1.getKey())>Integer.parseInt(o2.getKey())?1:Integer.parseInt(o1.getKey())<Integer.parseInt(o2.getKey())?-1:0;
			});
			
			answer=new int [list.size()];
			for (int i = 0; i < answer.length; i++) {
				if(list.get(i).getValue()>fees[0]) {//�⺻������ ū ��� 
					answer[i]=fees[1]+(int)Math.ceil((list.get(i).getValue()-fees[0])/(double)fees[2])*fees[3];
				} else {
					answer[i]=fees[1];
				}
			}
			return answer;
		}
	}

}
