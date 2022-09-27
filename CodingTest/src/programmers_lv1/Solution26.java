package programmers_lv1;

public class Solution26 {
	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        for (int i = 0; i < answer.length; i++) {
				answer[i]="";
			}
	        
	        String [] arr3=new String[n];
	        
	        String st1="";
	        String st2="";
	        String st3="";
	        
	        for (int i = 0; i < arr1.length; i++) {
	        	st1=Integer.toBinaryString(arr1[i]);
	        	st2=Integer.toBinaryString(arr2[i]);
	        	for (int j = 0; j < st1.length(); j++) {
	        		int k1=st1.charAt(j)-'0';
	        		int k2=st2.charAt(j)-'0';
	        		st3+=String.valueOf(k1+k2);
				}
	        	arr3[i]=st3;
	        }
	        
	        for (int i = 0; i < arr3.length; i++) {
				for (int j = 0; j < arr3[i].length(); j++) {
					if(arr3[i].charAt(j)!='0') {
						answer[i]+="#";
					} else {
						answer[i]+=" ";
					}
				}
			}
	        
	        return answer;
	    }
	}

	public static void main(String[] args) {
		int n=5;
		int[] arr1= {9, 20, 28, 18, 11};
		int[] arr2= {30, 1, 21, 17, 28};
		
		String[] answer = new String[n];
		for (int i = 0; i < answer.length; i++) {
			answer[i]="";
		}
        
        String [] arr3=new String[n];
        
        String st1="";
        String st2="";
        
        for (int i = 0; i < arr1.length; i++) {
        	String st3="";
        	st1=Integer.toBinaryString(i|i);
        	st2=Integer.toBinaryString(arr2[i]);
    		while(st1.length()<n) {
    			st1="0"+st1;
    		}
    		while(st2.length()<n) {
    			st2="0"+st2;
    		}
        	
        	for (int j = 0; j < n; j++) {
        		int k1=st1.charAt(j)-'0';
        		int k2=st2.charAt(j)-'0';
        		st3+=String.valueOf(k1+k2);
			}
        	arr3[i]=st3;
        }
        
        for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length(); j++) {
				if(arr3[i].charAt(j)!='0') {
					answer[i]+="#";
				} else {
					answer[i]+=" ";
				}
			}
		}
        System.out.println(answer[0]);
	}
}
