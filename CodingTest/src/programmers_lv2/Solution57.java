package programmers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution57 {
	public static void main(String[] args) {
		Solution57 s = new Solution57();
		s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}
	public List<Integer> solution(String s) {
        
        String string = s.substring(2, s.length()-2);
        
        
        String[] arr = string.split("\\},\\{");
        int[] answer = new int[arr.length];
        List<Integer> list = new LinkedList<Integer>();
        
        Arrays.sort(arr, (o1, o2) -> o1.length()-o2.length());
        // 문자의 길이를 기준으로 정렬 
        
        for(String str : arr) {
        	System.out.println("str "+str);
        	String[] arr2 = str.split(",");
        	for(String str2 : arr2) {
        		System.out.println("str2 "+str2);
        		int curInt = Integer.parseInt(str2);
        		if(!list.contains(curInt)) {
        			list.add(curInt);
        		}else {
        			continue;
        		}
        	}
        	
        }
        
        return list;
    }

}
