package algorithmTest;

import java.util.Arrays;
import java.util.Scanner;

public class Section6_9 {
	
	public int count(int[] arr, int capacity) {
		// 용량으로 몇장이 필요한지 
		int cnt = 1, sum = 0;// 한장 필요 (최대) , 현재 저장된 노래의 길이 
		for(int x : arr) {
			if(sum+x>capacity) {
				cnt++; // 새로운 장 
				sum = x; // 새로운 sum 에 더함 
			}else {
				sum+=x; // 현재 장에 계속 더함 
			}
		}
		return cnt;
	}
	
	public int T(int a, int b, int[] arr) {
		int answer = 0 ;
		int lt = Arrays.stream(arr).max().getAsInt(); // 최소 
		int rt = Arrays.stream(arr).sum(); // 최대 
		
		while(lt<=rt) {
			int mid = lt+rt/2;
			if(count(arr, mid)<=b) {
				answer = mid;
				rt = mid-1;
			} else {
				lt = mid+1;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Section6_9 section = new Section6_9();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
		}
		System.out.println(section.T(a, b, arr));
	}

}
