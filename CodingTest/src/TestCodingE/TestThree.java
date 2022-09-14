package TestCodingE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestThree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Pattern pat = Pattern.compile("[\\[](.*?)[]]");
		Matcher mat = pat.matcher(input);

		List<String> list = new ArrayList<String>();
		
		
		// 괄호에 있는 글자 추출 
		while (mat.find()) {
			if(mat.group(1).contains(",")) { // 쉼표로 2개 이상일때 
				String[] str=mat.group(1).split(",");
				for (int i = 0; i < str.length; i++) {
					list.add(str[i]);
				}
				
			} else { // 1개 있을 때 
				list.add(mat.group(1));
			}
			
			if(mat.group(1)==null) {
				break;
			}
		}
		
		// 중복 제거 (같으면 공란으로 변경)
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(i)==list.get(j)) {
					list.add(j, "");
				}
			}
		}
		
		List<String> newlist=new ArrayList<String>();
		
		// 공란으로 바뀐 리스트를 새로운 리스트에 추가 
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)!="") {
				newlist.add(list.get(i));
			}else {
				break;
			}
		}
		
		// 새로운 리스트를 배열에 담음 (인덱스 살림)
		String[] arr=new String[newlist.size()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=newlist.get(i);
		}
		
		
		
		// 다시..
		while (mat.find()) {
			if(mat.group(1).contains(",")) { // 쉼표로 2개 이상일때 
				String[] str=mat.group(1).split(",");
				for (int i = 0; i < str.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if(str[i]==arr[j]) {
							mat.group(1).replace(str[i], "j");
						}
					}
				}
				
			} else { // 1개 있을 때 
				for (int j = 0; j < arr.length; j++) {
					if(mat.group(1)==arr[j+1]) {
						mat.group(1).replace(mat.group(1), "j");
					}
				}
			}
			
			if(mat.group(1)==null) {
				break;
			}
		}
		
		System.out.println(input);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("["+(i+1)+"] "+arr[i]);
		}
	}

}
