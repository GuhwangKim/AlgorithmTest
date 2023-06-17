package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution11 {
	int mineralsMaxCount = 0;
	public int solution(int[] picks, String[] minerals) {
        /*
         * 1. p�� �迭�� 0�� �ƴ϶�� 
         * 2. ���� 5�� ���ٰ� ������ �������� 
         * 
         * */
        Queue<String> mineName = new LinkedList<String>();
        for (int i = 0; i < minerals.length; i++) {
			mineName.add(minerals[i]);
		}
        
       
        if(picks[0]>0) { //���̾���
        	for (int i = 0; i < 5; i++) {
        		mineName.poll();
				mineralsMaxCount++;
			}
        }
        
        if(picks[1]>0 & !mineName.isEmpty()) { //ö
        	if(mineName.size()>=5) {
        		for (int i = 0; i < 5; i++) {
            		String mineral = mineName.poll();
    				if(mineral.startsWith("d")) {
    					mineralsMaxCount+=5;
    				}else {
    					mineralsMaxCount++;
    				}
    			}
        	}else {
        		for (int i = 0; i < mineName.size(); i++) {
            		String mineral = mineName.poll();
    				if(mineral.startsWith("d")) {
    					mineralsMaxCount+=5;
    				}else {
    					mineralsMaxCount++;
    				}
    			}
        	}
        }
        
        if(picks[2]>0 & !mineName.isEmpty()) { //ö
        	if(mineName.size()>=5) {
        		for (int i = 0; i < 5; i++) {
            		String mineral = mineName.poll();
    				if(mineral.startsWith("d")) {
    					mineralsMaxCount+=25;
    				}else if (mineral.startsWith("i")) {
    					mineralsMaxCount+=5;
					} else {
						mineralsMaxCount++;
					}
    			}
        	}else {
        		for (int i = 0; i < mineName.size(); i++) {
            		String mineral = mineName.poll();
            		if(mineral.startsWith("d")) {
    					mineralsMaxCount+=25;
    				}else if (mineral.startsWith("i")) {
    					mineralsMaxCount+=5;
					} else {
						mineralsMaxCount++;
					}
    			}
        	}
        }
        return mineralsMaxCount;
    }
	
	
}
